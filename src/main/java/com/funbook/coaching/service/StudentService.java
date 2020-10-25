package com.funbook.coaching.service;

import com.funbook.coaching.dao.StudentDAO;
import com.funbook.coaching.dao.SubjectDAO;
import com.funbook.coaching.entity.StudentEntity;
import com.funbook.coaching.entity.SubjectEntity;
import com.funbook.coaching.model.SubjectStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    SubjectDAO subjectDAO;

    @Transactional
    public void registerToSubjects(SubjectStudent subjectStudent) {
        if (subjectStudent == null) {
            return;
        }

        StudentEntity studentEntity = studentDAO.findById(subjectStudent.getStudentId()).orElse(null);
        if (studentEntity == null) return;

        SubjectEntity subjectEntity = subjectDAO.findById(subjectStudent.getSubjectID()).orElse(null);
        if (subjectEntity == null) {
            return;
        }

        Set<SubjectEntity> subjectEntities = new HashSet<>();

        subjectEntities = studentEntity.getSubjectEntities();
        subjectEntities.add(subjectEntity);
        studentEntity.setSubjectEntities(subjectEntities);

        studentDAO.save(studentEntity);
    }

    public void registerStudent(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name not provided");
        }

        Set<SubjectEntity> schoolEntities = new HashSet<>();

        StudentEntity studentEntity = StudentEntity.builder()
                .userName(name)
                .subjectEntities(schoolEntities)
                .build();

        studentDAO.save(studentEntity);

    }

}
