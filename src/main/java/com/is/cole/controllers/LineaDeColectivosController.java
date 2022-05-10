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
import com.is.cole.dtos.colectivos.LineaDeColectivosDto;
import com.is.cole.services.lineas.ILineaColectivosService;

@RestController
@RequestMapping("/api/lineas_colectivos")
@Secured("ROLE_ADMIN")
public class LineaDeColectivosController {

	/**
	 * Agrega una nueva linea de colectivo
	 * @param dto
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> saveLineaColectivo(@RequestBody LineaDeColectivosDto dto) {
		try {
			LineaDeColectivosDto dtoGuardado = lineaService.saveLineaColectivo(dto);
			return ResponseEntity.status(HttpStatus.OK).body(dtoGuardado);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Obtiene una linea de colectivo por medio de un identificador
	 * @param lineaId
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> getLineaColectivo(@PathVariable("id") Integer lineaId) {
		try {
			LineaDeColectivosDto dtoObtenido = lineaService.getLineaColectivo(lineaId);
			return ResponseEntity.status(HttpStatus.OK).body(dtoObtenido);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Obitnene todas las lineas de colectivo
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> getAllLineaColectivo() {
		try {
			Result<LineaDeColectivosDto> dtos = lineaService.getAllLineaColectivo();
			return ResponseEntity.status(HttpStatus.OK).body(dtos);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Eliminar la linea de colectivo por medio de un identificador
	 * @param lineaId
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLineaColectivo(@PathVariable("id") Integer lineaId) {
		try {
			lineaService.deleteLineaColectivo(lineaId);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	

	@Autowired
	private ILineaColectivosService lineaService;

}
