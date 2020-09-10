package com.crud.crudLearn.dao;

import com.crud.crudLearn.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<StudentEntity, Integer> {
}
