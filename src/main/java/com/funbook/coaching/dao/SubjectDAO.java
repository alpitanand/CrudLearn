package com.funbook.coaching.dao;

import com.funbook.coaching.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDAO extends JpaRepository<SubjectEntity,Integer> {
}
