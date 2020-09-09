package com.crud.crudLearn.service;

import com.crud.crudLearn.dao.SchoolDAO;
import com.crud.crudLearn.entity.SchoolEntity;
import com.crud.crudLearn.entity.UserEntity;
import com.crud.crudLearn.model.RemoveSchoolPayload;
import com.crud.crudLearn.model.RemoveUserFromSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class SchoolService {

    @Autowired
    SchoolDAO schoolDAO;


    public SchoolEntity insertInSchool(SchoolEntity schoolEntity) {
        if (schoolEntity == null) {
            return null;
        }

        return schoolDAO.save(schoolEntity);
    }

    @Transactional
    public void removeUserFromSchool(RemoveUserFromSchool removeUserFromSchool) {
        SchoolEntity schoolEntity = schoolDAO.findById(removeUserFromSchool.getSchoolID()).orElse(null);
        if (schoolEntity == null) {
            throw new RuntimeException("School not found");
        }

        Set<UserEntity> userEntities = schoolEntity.getUserList();

        for (UserEntity userEntity : userEntities) {
            if (userEntity.getUserId() == removeUserFromSchool.getUserID()) {
                userEntities.remove(userEntity);
                break;
            }
        }

        schoolEntity.setUserList(userEntities);
        schoolDAO.save(schoolEntity);

    }

    public void removeSchool(RemoveSchoolPayload removeSchoolPayload) {
        SchoolEntity schoolEntity = schoolDAO.findById(removeSchoolPayload.getSchoolID()).orElse(null);
        if(schoolEntity==null){
            throw new RuntimeException("School not found");
        }
        schoolDAO.delete(schoolEntity);
    }
}
