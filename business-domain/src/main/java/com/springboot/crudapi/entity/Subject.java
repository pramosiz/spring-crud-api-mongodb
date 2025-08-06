package com.springboot.crudapi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document(collection = "subject")
public class Subject {

	@Id
	private String id;
	
	@Field(name = "subject")
	private String subjectName;
	
	@Field(name = "marks_obtained")
	private int marksObtained;
	
}
