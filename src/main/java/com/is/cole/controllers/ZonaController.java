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
import com.is.cole.dtos.zonas.ZonaDto;
import com.is.cole.services.zonas.IZonaService;

/**
 * Controlador para la zona de parada de colectivos
 * @author Colectuber
 */
@RestController
@RequestMapping("api/zonas")
@Secured("ROLE_ADMIN")
public class ZonaController {
	
	/**
	 * Agrega una nueva zona
	 * @param dto
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> saveZona(@RequestBody ZonaDto dto) {
		try {
			ZonaDto dtoGuardado = zonaService.saveZona(dto);
			return ResponseEntity.status(HttpStatus.OK).body(dtoGuardado);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Obtiene una zona por medio de su id
	 * @param zonaId
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> getByIdZona(@PathVariable("id") Integer zonaId) {
		try {
			ZonaDto dtoObtenido = zonaService.getByIdZona(zonaId);
			return ResponseEntity.status(HttpStatus.OK).body(dtoObtenido);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Obtiene todas las zonas 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> getAllZonas() {
		try {
			Result<ZonaDto> dtos = zonaService.getAllZonas();
			return ResponseEntity.status(HttpStatus.OK).body(dtos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Elimina una zona por medio de su id
	 * @param zonaId
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteZona(@PathVariable("id") Integer zonaId) {
		try {
			zonaService.deleteZona(zonaId);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/********************** Variables Privadas **********************/
	
	@Autowired
	private IZonaService zonaService;
}
