package com.springboot.mongoapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.mongoapi.entity.Subject;
import com.springboot.mongoapi.repository.SubjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectService {

	private final SubjectRepository subjectRepository;

	public List<Subject> getSubjects() {
		return subjectRepository.findAll();
	}
}
