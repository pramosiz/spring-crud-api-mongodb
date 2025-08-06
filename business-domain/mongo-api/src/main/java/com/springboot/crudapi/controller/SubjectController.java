package com.springboot.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudapi.entity.Subject;

import com.springboot.crudapi.service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@GetMapping
	public List<Subject> getSubjects() {
		return subjectService.getSubjects();
	}
	
}
