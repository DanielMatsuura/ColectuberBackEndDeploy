package com.is.cole.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.is.cole.dtos.colectuber.ColectivoUbicacionDto;
import com.is.cole.services.test.ITestService;

@RestController
@RequestMapping("/api/test")
public class TestController {

	@Autowired
	private ITestService testService;
	
	@PostMapping("/values")
	public ResponseEntity<?> postTestValues(){
		try {
			testService.insertValues();
			return ResponseEntity.status(HttpStatus.OK).build();
		}catch(Exception e) {
			System.err.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	
	}
	
}
