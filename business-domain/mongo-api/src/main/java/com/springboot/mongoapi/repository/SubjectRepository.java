package com.springboot.mongoapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mongoapi.entity.Subject;
import java.util.Optional;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String> {

    Optional<Subject> findBySubjectName(String subjectName);
}
