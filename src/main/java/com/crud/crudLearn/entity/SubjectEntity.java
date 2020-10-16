package com.crud.crudLearn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToMany(targetEntity = StudentEntity.class, mappedBy = "schoolEntities", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<StudentEntity> studentEntities;


}