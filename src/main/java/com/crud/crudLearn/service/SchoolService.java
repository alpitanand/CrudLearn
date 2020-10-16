package com.crud.crudLearn.service;

import com.crud.crudLearn.dao.SubjectDAO;
import com.crud.crudLearn.entity.SubjectEntity;
import com.crud.crudLearn.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    SubjectDAO subjectDAO;

    public SubjectEntity addSubject(SubjectEntity subjectEntity) {
        if (subjectEntity == null) {
            return null;
        }

        return subjectDAO.save(subjectEntity);
    }

//    @Transactional
//    public void removeUserFromSchool(RemoveStudentFromSchool removeStudentFromSchool) {
//        SchoolEntity schoolEntity = schoolDAO.findById(removeStudentFromSchool.getSchoolID()).orElse(null);
//        if (schoolEntity == null) {
//            throw new RuntimeException("School not found");
//        }
//
//        List<StudentEntity> userEntities = schoolEntity.getStudentEntities();
//
//        for (StudentEntity studentEntity : userEntities) {
//            if (studentEntity.getUserId() == removeStudentFromSchool.getUserID()) {
//                userEntities.remove(studentEntity);
//                break;
//            }
//        }
//
//        schoolEntity.setStudentEntities(userEntities);
//        schoolDAO.save(schoolEntity);
//
//    }

    public void removeSchool(Subject subject) {
        SubjectEntity subjectEntity = subjectDAO.findById(subject.getSubjectId()).orElse(null);
        if (subjectEntity == null) {
            throw new RuntimeException("School not found");
        }
        subjectDAO.delete(subjectEntity);
    }

    @Transactional
    public Optional<SubjectEntity> getSchool(Subject subject) {
        return subjectDAO.findById(subject.getSubjectId());
    }
}
