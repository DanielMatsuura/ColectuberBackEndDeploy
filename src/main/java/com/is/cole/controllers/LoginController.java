package com.is.cole.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.is.cole.entities.AuthRequest;
import com.is.cole.util.JwtUtil;

/**
 * Controlador para la autenticacion
 * @author Colectuber
 */
@RestController
public class LoginController {
	
	/**
	 * Se genera el token si se autentica correctamente
	 * @param authRequest
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			System.err.print(ex);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Inavalid username/password");
		}

		return ResponseEntity.status(HttpStatus.OK).body(jwUtil.generateToken(authRequest.getUserName()));
	}
	
	@Autowired
	private JwtUtil jwUtil;
	@Autowired
	private AuthenticationManager authenticationManager;


}
