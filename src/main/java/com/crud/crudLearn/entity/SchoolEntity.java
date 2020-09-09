package com.crud.crudLearn.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table
public class SchoolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int schoolId;

    @Column
    private String schoolName;

    @Column
    @OneToMany(mappedBy = "schoolEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserEntity> userList;
}