package com.springboot.crudapi.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {					// JSON field's names

	private String id;					
	
	private String name;
	
	private String mail;
	
	private DepartmentDTO department;

	private List<SubjectDTO> subjects;
	
}
