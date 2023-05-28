package com.springboot.crudapi.dto;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubjectDTO {			// JSON field's names

	private ObjectId id;
	
	private String subject;
	
	private int marks_obtained;	
	
}
