package com.springboot.crudapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubjectDTO {			// JSON field's names

	private String id;
	
	private String subject;
	
	private int marks_obtained;	
	
}
