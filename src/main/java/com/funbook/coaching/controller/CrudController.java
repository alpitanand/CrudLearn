package com.funbook.coaching.controller;

import com.funbook.coaching.entity.SubjectEntity;
import com.funbook.coaching.model.Student;
import com.funbook.coaching.model.Subject;
import com.funbook.coaching.model.SubjectStudent;
import com.funbook.coaching.service.SubjectService;
import com.funbook.coaching.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(CrudController.class);

    @GetMapping("/health")
    public String healthCheck(){
        logger.info("I am getting logged");
        return "I am healthy";
    }

    @PostMapping("/addSubject")
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
