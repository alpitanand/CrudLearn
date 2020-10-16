package com.crud.crudLearn.controller;

import com.crud.crudLearn.entity.SubjectEntity;
import com.crud.crudLearn.model.Subject;
import com.crud.crudLearn.model.Student;
import com.crud.crudLearn.model.SubjectStudent;
import com.crud.crudLearn.service.SchoolService;
import com.crud.crudLearn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CrudController {

    @Autowired
    SchoolService schoolService;

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
       return schoolService.addSubject(subjectEntity);
    }

//    @PostMapping("/removeStudent")
//    public void removeStudentFromSchool(@RequestBody RemoveStudentFromSchool removeStudentFromSchool){
//        if(removeStudentFromSchool ==null){
//            throw new IllegalArgumentException("Params not provided");
//        }
//
//        schoolService.removeUserFromSchool(removeStudentFromSchool);
//
//    }

    @PostMapping("/removeSchool")
    public void removeSchool(@RequestBody Subject subject){
        if(subject ==null){
            throw new IllegalArgumentException("Params not provided");
        }
    schoolService.removeSchool(subject);
    }

    @PostMapping("/takeSubject")
    public void takeSubject(@RequestBody SubjectStudent studentEntity){
        if(studentEntity == null){
            throw new IllegalArgumentException("Params not provided");
        }
        studentService.registerToSubjects(studentEntity);
    }

    @PostMapping("/registerStudent")
    public void registerStudent(@RequestBody Student student){
        if(StringUtils.isEmpty(student)){
            throw new IllegalArgumentException("Params not provided");
        }
        studentService.registerStudent(student.getName());
    }


    @GetMapping("/school")
    public Optional<SubjectEntity> getSchool(@RequestBody Subject subject){
        Optional<SubjectEntity> schoolEntity = schoolService.getSchool(subject);
        return schoolEntity;
    }

}
