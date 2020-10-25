package com.funbook.coaching.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
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
    @JoinTable(name = "student_subject")
    private Set<SubjectEntity> subjectEntities;
}