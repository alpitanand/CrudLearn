package com.crud.crudLearn.dao;

import com.crud.crudLearn.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDAO extends JpaRepository<SubjectEntity,Integer> {
}
