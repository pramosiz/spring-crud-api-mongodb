package com.springboot.crudapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crudapi.entity.Department;


@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {

}
