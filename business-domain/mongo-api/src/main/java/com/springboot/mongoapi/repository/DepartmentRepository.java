package com.springboot.mongoapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mongoapi.entity.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {

}
