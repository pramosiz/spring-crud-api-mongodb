package com.springboot.crudapi.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.crudapi.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, ObjectId> {
	
	List<Student> findByName(String name);
	
	@Query("{ \"name\" : \"?0\" }")
	List<Student> findByNombre(String name);
	
	List<Student> findByNameAndEmail(String name, String email);
	
	List<Student> findByNameOrEmail(String name, String email);
	
//  It doesn't work because Department and Subjects are different documents right now
//	List<Student> findByDepartmentDepartmentName(String deptName);
//	
//	List<Student> findBySubjectsSubjectName(String subName);
	
	List<Student> findByEmailIsLike(String email);
	
	List<Student> findByNameStartsWith(String name);
}
