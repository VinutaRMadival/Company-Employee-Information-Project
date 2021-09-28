package com.vco.project.payload;

import com.vco.project.model.EmployeeDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponsePayload {
		
		
		
		private int statusCode;
		private String message;
		private Object obj;
		
		
}
