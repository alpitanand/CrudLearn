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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int subjectId;

    @Column
    private String subjectName;

}