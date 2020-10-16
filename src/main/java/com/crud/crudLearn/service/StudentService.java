package com.crud.crudLearn.service;

import com.crud.crudLearn.dao.StudentDAO;
import com.crud.crudLearn.dao.SubjectDAO;
import com.crud.crudLearn.entity.StudentEntity;
import com.crud.crudLearn.entity.SubjectEntity;
import com.crud.crudLearn.model.SubjectStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    SubjectDAO subjectDAO;

    public void registerToSubjects(SubjectStudent subjectStudent) {
        if (subjectStudent == null) {
            return;
        }
        SubjectEntity subjectEntity = subjectDAO.findById(subjectStudent.getSubjectID()).orElse(null);
        if (subjectEntity == null) {
            return;
        }

        StudentEntity studentEntity = studentDAO.findById(subjectStudent.getStudentId()).orElse(null);

        if (studentEntity == null) return;

        Set<SubjectEntity> schoolEntities = new HashSet<>();

        schoolEntities = studentEntity.getSchoolEntities();
        schoolEntities.add(subjectEntity);

        studentDAO.save(studentEntity);
    }

    public void registerStudent(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name not provided");
        }

        Set<SubjectEntity> schoolEntities = new HashSet<>();

        StudentEntity studentEntity = StudentEntity.builder()
                .userName(name)
                .schoolEntities(schoolEntities)
                .build();

        studentDAO.save(studentEntity);

    }

}
