package ru.teachbase.go.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@ToString(exclude = {"userEntity"})
@Getter
@Setter
@Entity
@Table(name = "ACCOUNT_ENTITY", schema = "ACCOUNT_ENTITY")
@NoArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "BALANCE")
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "USER_ENTITY_ID")
    private UserEntity userEntity;

    @Column(name = "USER_ENTITY_ID", insertable = false, updatable = false)
    private Integer userEntityId;

}