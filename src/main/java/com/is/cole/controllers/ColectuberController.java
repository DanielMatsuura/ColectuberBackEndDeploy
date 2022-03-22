package com.is.cole.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.is.cole.dtos.colectuber.ColectivoUbicacionDto;
import com.is.cole.dtos.colectuber.ColectivoUbicacionResult;
import com.is.cole.services.colectuber.IColectuberService;

@RestController
@RequestMapping("/api/colectuber")
public class ColectuberController {
	
	@Autowired
	private IColectuberService colectuberService;
	
	
	@PostMapping("/ubicacion")
	public ResponseEntity<?> postColectivoUbicacion(@RequestBody ColectivoUbicacionDto dto){
		try {
			colectuberService.postColectivoUbicacion(dto);
			return ResponseEntity.status(HttpStatus.OK).build();
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	
	}
	
	@GetMapping("/ubicaciones")
	public ResponseEntity<?> getColectivosUbicacion(){
		try {
			ColectivoUbicacionResult dtos = colectuberService.getColectivosUbicacion();
			return ResponseEntity.status(HttpStatus.FOUND).body(dtos);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	

}
