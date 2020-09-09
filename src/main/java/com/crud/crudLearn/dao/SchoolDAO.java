package com.crud.crudLearn.dao;

import com.crud.crudLearn.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDAO extends JpaRepository<SchoolEntity,Integer> {
}
