package com.springboot.mongoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewSubjectDTO {

	private String subject;
	private int marks_obtained;
}
