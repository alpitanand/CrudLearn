package com.crud.crudLearn.service;

import com.crud.crudLearn.dao.UserDAO;
import com.crud.crudLearn.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public void insertUser(UserEntity userEntity){
        if(userEntity==null){
            return;
        }
        userDAO.save(userEntity);
    }
}
