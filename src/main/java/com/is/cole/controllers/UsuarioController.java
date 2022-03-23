package com.is.cole.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.is.cole.dtos.Usuarios.UsuarioDto;
import com.is.cole.services.usuarios.IUsuariosService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuariosService usuariosService;
	
	@PostMapping
	public ResponseEntity<?> postUsuario(@RequestBody UsuarioDto dto){
		try {
			UsuarioDto dtoGuardado = usuariosService.saveUsuario(dto);
			return ResponseEntity.status(HttpStatus.OK).body(dtoGuardado);
		}catch(Exception e){
			System.err.print(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUsuario(@PathVariable(value = "id")Integer id){
		try {
			UsuarioDto dtoObtenido = usuariosService.getUsuario(id);
			return ResponseEntity.status(HttpStatus.OK).body(dtoObtenido);
		}catch(Exception e){
			System.err.print(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable(value = "id")Integer id){
		try {
			usuariosService.deleteUsuario(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}catch(Exception e){
			System.err.print(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	
}
