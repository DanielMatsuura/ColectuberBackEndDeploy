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
import com.is.cole.dtos.Viajes.ViajeDto;
import com.is.cole.services.viajes.IViajesService;

/**
 * Controlador para el servicio de los viajes
 * @author Colectuber
 */
@RestController
@RequestMapping("api/viajes")
@Secured("ROLE_ADMIN")
public class ViajeController {

	/**
	 * Save y Update de un viaje
	 * @param dto
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> postViaje(@RequestBody ViajeDto dto) {
		try {
			viajeService.saveViaje(dto);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/**
	 * Se obtiene un viaje por id
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> getViaje(@PathVariable("id") Integer id) {
		try {
			ViajeDto dto = viajeService.getViaje(id);
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/**
	 * Se obtiene un viaje por el chofer id
	 * @param choferId
	 * @return
	 */
	@GetMapping("/chofer/{id}")
	public ResponseEntity<?> getChoferViaje(@PathVariable("id") Integer choferId) {
		try {
			ViajeDto dto = viajeService.getByChoferIdViaje(choferId);
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/**
	 * Se obtiene todos los viajes 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> getAllViajes() {
		try {
			Result<ViajeDto> dtos = viajeService.getAllViajes();
			return ResponseEntity.status(HttpStatus.OK).body(dtos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/**
	 * Se elimina un viaje por medio de su id 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteViaje(@PathVariable("id") Integer id) {
		try {
			viajeService.deleteViaje(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Autowired
	private IViajesService viajeService;

}
