package com.springboot.crudapi.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "student")
public class Student {

	@Id
	@Field("_id")
	private ObjectId id;
	
	private String name;
	
	@Field(name = "mail")				// Name when read
	private String email;				// Name when create
	
	@DBRef
	private Department department;

	@DBRef
	private List<Subject> subjects;
	
	@Transient							// Transient no serializa el atributo
	private double percentage;
	
	public double getPercentage() {
		if((this.subjects != null) && (!this.subjects.isEmpty())) {
			double total = 0;
			for(Subject subject : this.subjects) {
				total += subject.getMarksObtained();
			}
			return total/subjects.size();
		}
		return 0.0;
	}
	
}
