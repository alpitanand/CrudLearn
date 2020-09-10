package com.crud.crudLearn.service;

import com.crud.crudLearn.dao.UserDAO;
import com.crud.crudLearn.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public void insertUser(StudentEntity studentEntity){
        if(studentEntity ==null){
            return;
        }
        userDAO.save(studentEntity);
    }
}
