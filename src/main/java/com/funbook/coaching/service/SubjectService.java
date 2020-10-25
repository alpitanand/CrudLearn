package com.funbook.coaching.service;

import com.funbook.coaching.dao.SubjectDAO;
import com.funbook.coaching.entity.SubjectEntity;
import com.funbook.coaching.model.Subject;
import com.funbook.coaching.util.CoachingConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    SubjectDAO subjectDAO;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    String studentTopic = CoachingConstants.STUDENT_TOPIC;

    public SubjectEntity addSubject(SubjectEntity subjectEntity) {
        if (subjectEntity == null) {
            return null;
        }
        SubjectEntity savedSubjectEntity =  subjectDAO.save(subjectEntity);
        kafkaTemplate.send(studentTopic, savedSubjectEntity.toString());
        return savedSubjectEntity;
    }


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

    public void removeSubject(int subjectId) {

    }
}
