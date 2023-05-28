package com.springboot.crudapi.dto;

import java.util.List;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {					// JSON field's names

	private ObjectId id;					
	
	private String name;
	
	private String mail;
	
	private DepartmentDTO department;

	private List<SubjectDTO> subjects;
	
}
