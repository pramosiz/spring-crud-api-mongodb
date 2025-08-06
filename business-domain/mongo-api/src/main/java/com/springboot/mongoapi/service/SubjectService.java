package com.springboot.mongoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mongoapi.entity.Subject;
import com.springboot.mongoapi.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	public List<Subject> getSubjects() {
		return subjectRepository.findAll();
	}
}
