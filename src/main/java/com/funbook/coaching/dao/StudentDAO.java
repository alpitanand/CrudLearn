package com.funbook.coaching.dao;

import com.funbook.coaching.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO extends JpaRepository<StudentEntity, Integer> {
}
