package com.springboot.crudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crudapi.entity.Subject;
import com.springboot.crudapi.repository.SubjectRepository;

@Service
public class SubjectService {

	
	@Autowired
	private SubjectRepository subjectRepository;
	
	public List<Subject> getSubjects() {
		return subjectRepository.findAll();
	}
}
