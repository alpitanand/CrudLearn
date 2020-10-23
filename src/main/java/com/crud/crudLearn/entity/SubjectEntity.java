package com.crud.crudLearn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
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

    @JsonIgnore
    @ManyToMany(mappedBy = "subjectEntities")
    private Set<StudentEntity> studentEntities;


}