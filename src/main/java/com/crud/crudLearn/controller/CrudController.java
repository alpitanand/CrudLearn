package com.crud.crudLearn.controller;

import com.crud.crudLearn.entity.SubjectEntity;
import com.crud.crudLearn.model.Student;
import com.crud.crudLearn.model.Subject;
import com.crud.crudLearn.model.SubjectStudent;
import com.crud.crudLearn.service.SubjectService;
import com.crud.crudLearn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CrudController {

    @Autowired
    SubjectService subjectService;

    @Autowired
    StudentService studentService;

    @GetMapping("/health")
    public String healthCheck(){
        return "I am healthy";
    }

    @PostMapping("/school")
    public SubjectEntity createSchool(@RequestBody SubjectEntity subjectEntity){
        if(subjectEntity.getSubjectName()==null){
            throw new IllegalArgumentException("School name not given");
        }
       return subjectService.addSubject(subjectEntity);
    }


    @PostMapping("/removeSchool")
    public void removeSchool(@RequestBody Subject subject){
        if(subject ==null){
            throw new IllegalArgumentException("Params not provided");
        }
    subjectService.removeSchool(subject);
    }

    @PostMapping("/takeSubject")
    public void takeSubject(@RequestBody SubjectStudent studentEntity){
        if(studentEntity == null){
            throw new IllegalArgumentException("Params not provided");
        }
        studentService.registerToSubjects(studentEntity);
    }

    @PostMapping("/registerStudent")
    public void registerStudent(@RequestBody Student student) {
        if (StringUtils.isEmpty(student)) {
            throw new IllegalArgumentException("Params not provided");
        }
        studentService.registerStudent(student.getName());
    }

    @PostMapping("/removeSubject")
    public void removeSubject(@RequestBody Subject subject) {
        if (subject == null || StringUtils.isEmpty(subject.getSubjectId())) {
            throw new IllegalArgumentException("Params not provided");
        }

        subjectService.removeSubject(subject.getSubjectId());

    }

    @GetMapping("/school")
    public Optional<SubjectEntity> getSchool(@RequestBody Subject subject) {
        Optional<SubjectEntity> schoolEntity = subjectService.getSchool(subject);
        return schoolEntity;
    }

}
