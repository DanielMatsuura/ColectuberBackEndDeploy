package com.is.cole.controllers;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.is.cole.dtos.role.RoleDto;
import com.is.cole.dtos.role.RoleUsuarioDto;
import com.is.cole.services.role.IRoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	
	@PostMapping()
	public ResponseEntity<?> create(@RequestBody RoleDto role){
		try {
			System.out.println(role);
			RoleDto dto = roleService.saveRole(role);
			return ResponseEntity.status(HttpStatus.CREATED).body(dto);
		}catch (IllegalArgumentException e) {
			System.err.println("Ha ocurrido un error durante la creacion del role.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (EntityNotFoundException | JpaObjectRetrievalFailureException e) {
			System.err.println("Ha ocurrido un error durante la creacion del role.");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			System.err.println("Ha ocurrido un error inesperado");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		try {
			roleService.deleteRole(id);
			System.out.println("Se borro el role con id: " + id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}catch (IllegalArgumentException e) {
			System.err.println("Ha ocurrido un error al querer borrar los datos");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (EntityNotFoundException | JpaObjectRetrievalFailureException e) {
			System.err.println("Ha ocurrido un error al querer borrar los datos");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			System.err.println("Ha ocurrido un error inesperado");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/rolUsuario")
	public ResponseEntity<?> agregarRolAUsuario(@RequestBody RoleUsuarioDto dto){
		try {
			RoleUsuarioDto dtoGuardado = roleService.agregarRoleAUsuario(dto);
			return ResponseEntity.status(HttpStatus.OK).body(dtoGuardado);
		}catch(Exception e) {
			System.err.print(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping("/rolUsuario/{id}")
	public ResponseEntity<?> sacarRolAUsuario(@PathVariable("id") Integer id){
		try {
			roleService.quitarRoleAUsuario(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}catch (IllegalArgumentException e) {
			System.err.println("Ha ocurrido un error al querer borrar los datos");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (EntityNotFoundException | JpaObjectRetrievalFailureException e) {
			System.err.println("Ha ocurrido un error al querer borrar los datos");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			System.err.println("Ha ocurrido un error inesperado");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	
}
