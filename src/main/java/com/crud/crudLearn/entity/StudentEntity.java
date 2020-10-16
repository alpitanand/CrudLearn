package com.crud.crudLearn.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int userId;

    @Column
    private String userName;

    @ManyToMany
    private Set<SubjectEntity> schoolEntities;
}