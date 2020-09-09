package com.crud.crudLearn.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int userId;

    @Column
    private String userName;

    @ManyToOne
    private SchoolEntity schoolEntity;

}