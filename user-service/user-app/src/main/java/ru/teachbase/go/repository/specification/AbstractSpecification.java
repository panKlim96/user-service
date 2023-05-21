package ru.teachbase.go.repository.specification;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public abstract class AbstractSpecification<T> implements Specification<T> {
    @Override
    public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
        return null;
    }

    @NonNull
    protected abstract Stream<Predicate> getPredicates(@NotNull Root<T> root,
                                                       CriteriaQuery<?> criteriaQuery,
                                                       @NotNull CriteriaBuilder cb);

    protected Predicate betweenDates(Root<?> root,
                                     CriteriaBuilder cb,
                                     String fieldName,
                                     Pair<LocalDate, LocalDate> dates) {

        if (isPairNullOrContainsOnlyNullValues(dates)) {
            return null;
        }

        if (isBothPairValuesNotNull(dates)) {
            return cb.between(root.get(fieldName).as(LocalDate.class), dates.getLeft(), dates.getRight());
        }

        return nonNull(dates.getLeft()) ? greaterOrEquals(root, cb, fieldName, dates.getLeft()) :
                lessOrEquals(root, cb, fieldName, dates.getRight());
    }

    protected Predicate greaterOrEquals(Root<?> root,
                                        CriteriaBuilder cb,
                                        String fieldName,
                                        LocalDate startDate) {
        return cb.greaterThanOrEqualTo(root.get(fieldName).as(LocalDate.class), startDate);
    }

    protected Predicate lessOrEquals(Root<?> root,
                                     CriteriaBuilder cb,
                                     String fieldName,
                                     LocalDate endDate) {
        return cb.lessThanOrEqualTo(root.get(fieldName).as(LocalDate.class), endDate);
    }

    protected Predicate likeValue(Root<?> root,
                                  CriteriaBuilder cb,
                                  String fieldName,
                                  String value) {
        return nonNull(value) ? cb.like(cb.upper(root.get(fieldName)), "%" + StringUtils.upperCase(value) + "%") : null;
    }

    protected Predicate equalsValue(Root<?> root,
                                    CriteriaBuilder cb,
                                    String fieldName,
                                    String value) {
        return nonNull(value) ? cb.equal(root.get(fieldName), value) : null;
    }


    protected Predicate betweenJoinBalance(Root<?> root,
                                           CriteriaBuilder cb,
                                           String fieldName,
                                           String joinColumnName,
                                           Pair<BigDecimal, BigDecimal> balanceRange) {

        if (isPairNullOrContainsOnlyNullValues(balanceRange)) {
            return null;
        }

        if (isBothPairValuesNotNull(balanceRange)) {
            cb.between(root.join(joinColumnName).get(fieldName).as(BigDecimal.class), balanceRange.getLeft(), balanceRange.getRight());
        }

        return nonNull(balanceRange.getLeft()) ? greaterOrEqualsJoin(root, cb, fieldName, joinColumnName, balanceRange.getLeft())
                : lessOrEqualsJoin(root, cb, fieldName, joinColumnName, balanceRange.getRight());

    }
    protected Predicate greaterOrEqualsJoin(Root<?> root,
                                            CriteriaBuilder cb,
                                            String fieldName,
                                            String joinColumnName,
                                            BigDecimal minBalance) {
        return cb.greaterThanOrEqualTo(root.join(joinColumnName).get(fieldName).as(BigDecimal.class), minBalance);
    }

    protected Predicate lessOrEqualsJoin(Root<?> root,
                                         CriteriaBuilder cb,
                                         String fieldName,
                                         String joinColumnName,
                                         BigDecimal minBalance) {
        return cb.lessThanOrEqualTo(root.join(joinColumnName).get(fieldName).as(BigDecimal.class), minBalance);
    }

    protected Predicate lessOrEqualsJoin(Root<?> root,
                                         CriteriaBuilder cb,
                                         String fieldName,
                                         LocalDate endDate) {
        return cb.lessThanOrEqualTo(root.get(fieldName).as(LocalDate.class), endDate);
    }

    protected boolean isPairNullOrContainsOnlyNullValues(Pair<?, ?> pair) {
        if (isNull(pair) || isBothPairValuesNotNull(pair)) {
            return true;
        }

        return false;
    }

    protected boolean isBothPairValuesNotNull(Pair<?, ?> dates) {
        return nonNull(dates.getRight()) && nonNull(dates.getLeft());
    }
}
