package com.is.cole.controllers;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.is.cole.dtos.Result;
import com.is.cole.dtos.colectuber.ColectivoUbicacionDto;
import com.is.cole.dtos.colectuber.InitialDataDto;
import com.is.cole.dtos.colectuber.InitialViajeDto;
import com.is.cole.dtos.colectuber.UsuarioChoferDto;
import com.is.cole.services.colectuber.IColectuberService;

/**
 * Controlador para los servicios principales tanto para la web y la app
 * @author Colectuber 
 */
@RestController
@RequestMapping("/api/colectuber")
public class ColectuberController {
	
	/**
	 * Save y Update del ubicacion de un colectivo
	 * @param dto
	 * @return
	 */
	@Secured("ROLE_CHOFER")
	@PostMapping("/ubicacion")
	public ResponseEntity<?> postColectivoUbicacion(@RequestBody ColectivoUbicacionDto dto) {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			colectuberService.postColectivoUbicacion(dto,username);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	/**
	 * Se obtiene todas las ubicaciones de los colectivos
	 * @return
	 */
	@GetMapping("/ubicaciones")
	@CrossOrigin
	public ResponseEntity<?> getColectivosUbicacion() {
		try {
			Result<ColectivoUbicacionDto> dtos = colectuberService.getColectivosUbicacion();
			return ResponseEntity.status(HttpStatus.OK).body(dtos);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	/**
	 * Se obtiene los datos iniciales de la aplicacion web: colectivos, colectivos ubicacion,
	 * recorridos y paradas
	 * @return
	 */
	@GetMapping("/get-data")
	public ResponseEntity<?> getInitialData() {
		try {
			InitialDataDto dtos = colectuberService.getInitialData();
			return ResponseEntity.status(HttpStatus.OK).body(dtos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Se obtiene el chofer por medio de su token de autenticado
	 * @return
	 */
	@Secured("ROLE_CHOFER")
	@GetMapping("/get-chofer")
	public ResponseEntity<?> getChofer() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			UsuarioChoferDto dto = colectuberService.getChofer(username);
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		}catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/**
	 * Se obtiene el viaje de un chofer por medio de su token de autenticado
	 * @return
	 */
	@Secured("ROLE_CHOFER")
	@GetMapping("/get-viaje")
	public ResponseEntity<?> getViaje() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			InitialViajeDto dto = colectuberService.getViaje(username);
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Autowired
	private IColectuberService colectuberService;

}
