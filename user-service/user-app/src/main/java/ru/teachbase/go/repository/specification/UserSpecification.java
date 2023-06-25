package ru.teachbase.go.repository.specification;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import ru.teachbase.go.model.UserCriteriaFilter;
import ru.teachbase.go.model.UserEntity_;
import ru.teachbase.go.model.AccountEntity_;
import ru.teachbase.go.model.UserEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class UserSpecification extends AbstractSpecification<UserEntity> {

    private final UserCriteriaFilter userCriteriaFilter;

    @Override
    protected @NonNull Stream<Predicate> getPredicates(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        return Stream.of(
                likeValue(root, cb, UserEntity_.NAME, userCriteriaFilter.getLikeName()),
                likeValue(root, cb, UserEntity_.EMAIL, userCriteriaFilter.getLikeEmail()),
                betweenDates(root, cb, UserEntity_.DATE_OF_BIRTH, Pair.of(userCriteriaFilter.getStartDate(),
                        userCriteriaFilter.getEndDate())),
                //equalsValue(root, cb, UserEntity_., userCriteriaFilter.ema),
                betweenJoinBalance(root, cb, AccountEntity_.BALANCE, UserEntity_.ACCOUNTS, Pair.of(userCriteriaFilter.getMinBalance(),
                        userCriteriaFilter.getMaxBalance()))
        );
    }
}