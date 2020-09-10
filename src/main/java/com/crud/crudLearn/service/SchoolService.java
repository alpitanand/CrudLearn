package com.crud.crudLearn.service;

import com.crud.crudLearn.dao.SchoolDAO;
import com.crud.crudLearn.entity.SchoolEntity;
import com.crud.crudLearn.entity.StudentEntity;
import com.crud.crudLearn.model.RemoveSchoolPayload;
import com.crud.crudLearn.model.RemoveStudentFromSchool;
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
    public void removeUserFromSchool(RemoveStudentFromSchool removeStudentFromSchool) {
        SchoolEntity schoolEntity = schoolDAO.findById(removeStudentFromSchool.getSchoolID()).orElse(null);
        if (schoolEntity == null) {
            throw new RuntimeException("School not found");
        }

        Set<StudentEntity> userEntities = schoolEntity.getUserList();

        for (StudentEntity studentEntity : userEntities) {
            if (studentEntity.getUserId() == removeStudentFromSchool.getUserID()) {
                userEntities.remove(studentEntity);
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
