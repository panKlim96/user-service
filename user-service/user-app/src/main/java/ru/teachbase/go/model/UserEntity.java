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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@ToString(exclude = {"accounts"})
@Getter
@Setter
@Entity
@Table(name = "USER_ENTITY", schema = "USER_ENTITY")
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    //@OneToMany(targetEntity = AccountEntity.class, cascade = CascadeType.MERGE, orphanRemoval = true, mappedBy = "userEntity")
    @OneToMany( mappedBy = "userEntity", fetch = FetchType.LAZY)
    private List<AccountEntity> accounts;

}