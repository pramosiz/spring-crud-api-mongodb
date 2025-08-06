package com.springboot.crudapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crudapi.entity.Subject;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String> {

}
