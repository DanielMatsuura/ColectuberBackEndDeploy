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
import com.is.cole.dtos.recorridos.RecorridoDto;
import com.is.cole.services.recorridos.IRecorridoService;

/**
 * Controlador para el servicio de recorrido de un colectivo
 * @author Colectuber
 */
@RestController
@RequestMapping("/api/recorridos")
@Secured("ROLE_ADMIN")
public class RecorridoController {

	/**
	 * Save y Update de un recorrido
	 * @param dto
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> postRecorrido(@RequestBody RecorridoDto dto) {
		try {
			recorridoService.saveRecorrido(dto);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/**
	 * Se obtiene un recorrido por el id 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> getRecorrido(@PathVariable("id") Integer id) {
		try {
			RecorridoDto dto = recorridoService.getRecorrido(id);
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/**
	 * Se obtiene todos los recorridos
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> getAllRecorridos() {
		try {
			Result<RecorridoDto> dtos = recorridoService.getAllRecorrido();
			return ResponseEntity.status(HttpStatus.OK).body(dtos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/**
	 * Se elimina un recorrido por su id 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRecorrido(@PathVariable("id") Integer id) {
		try {
			recorridoService.deleteRecorrido(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Autowired
	private IRecorridoService recorridoService;

}
