package com.is.cole.controllers;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.is.cole.dtos.Result;
import com.is.cole.dtos.colores.ColorDto;
import com.is.cole.services.colores.IColorService;

@RestController
@RequestMapping("/api/colores")
@Secured("ROLE_ADMIN")
public class ColorController {

	/**
	 * Agrega un color nuevo
	 * @param dto
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> postColor(@RequestBody ColorDto dto) {
		try {
			ColorDto dtoGuardado = colorService.saveColor(dto);
			return ResponseEntity.status(HttpStatus.OK).body(dtoGuardado);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/**
	 * Obtiene un color por medio de un identificador
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> getColor(@PathVariable(value = "id") Integer id){
		try {
			ColorDto dtoObtenido = colorService.getColorById(id);
			return ResponseEntity.status(HttpStatus.OK).body(dtoObtenido);
		}catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/**
	 * Obtiene todos los colores
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> getAllColores(){
		try {
			Result<ColorDto> dtos = colorService.getAllColors();
			return ResponseEntity.status(HttpStatus.OK).body(dtos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/**
	 * Elimina un color por medio de un identificador
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteColor(@PathVariable(value = "id") Integer id){
		try {
			colorService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Autowired
	private IColorService colorService;
	
	
}
