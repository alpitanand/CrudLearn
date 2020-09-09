package com.crud.crudLearn.controller;

import com.crud.crudLearn.entity.SchoolEntity;
import com.crud.crudLearn.entity.UserEntity;
import com.crud.crudLearn.model.RemoveSchoolPayload;
import com.crud.crudLearn.model.RemoveUserFromSchool;
import com.crud.crudLearn.service.SchoolService;
import com.crud.crudLearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CrudController {

    @Autowired
    SchoolService schoolService;

    @Autowired
    UserService userService;

    @GetMapping("/health")
    public String healthCheck(){
        return "I am healthy";
    }

    @PostMapping("/school")
    public SchoolEntity createSchool(@RequestBody SchoolEntity schoolEntity){
        if(schoolEntity.getSchoolName()==null){
            throw new IllegalArgumentException("School name not given");
        }
       return schoolService.insertInSchool(schoolEntity);
    }

    @PostMapping("/removeUser")
    public void removeUserFromSchool(@RequestBody RemoveUserFromSchool removeUserFromSchool){
        if(removeUserFromSchool==null){
            throw new IllegalArgumentException("Params not provided");
        }

        schoolService.removeUserFromSchool(removeUserFromSchool);

    }

    @PostMapping("/removeSchool")
    public void removeSchool(@RequestBody RemoveSchoolPayload removeSchoolPayload){
        if(removeSchoolPayload==null){
            throw new IllegalArgumentException("Params not provided");
        }
    schoolService.removeSchool(removeSchoolPayload);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody UserEntity userEntity){
        if(userEntity == null){
            throw new IllegalArgumentException("Params not provided");
        }
        userService.insertUser(userEntity);
    }
}
