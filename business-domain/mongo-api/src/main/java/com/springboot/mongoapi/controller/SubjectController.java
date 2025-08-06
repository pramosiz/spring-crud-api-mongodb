package com.springboot.mongoapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongoapi.entity.Subject;
import com.springboot.mongoapi.service.SubjectService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/subjects")
@RequiredArgsConstructor
@Tag(name = "Subject", description = "v1")
public class SubjectController {

	private final SubjectService subjectService;

	@GetMapping
	@Operation(summary = "Get all Subjects", description = "Service to get all Subjects", responses = @ApiResponse(responseCode = "200", description = "Success"))
	public ResponseEntity<List<Subject>> getSubjects() {
		return ResponseEntity.ok(subjectService.getSubjects());
	}

}
