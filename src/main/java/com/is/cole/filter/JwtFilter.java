package com.is.cole.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.is.cole.services.userDetails.CustomUserDetailsService;
import com.is.cole.util.JwtUtil;

/**
 * Componente utilizado para la autorizacion por medio de token jwt
 * @author Colectuber
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

	/**
	 * Es un filtro que obtiene el token del request verifica las credenciales y valida el token
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		//Obtiene el token
		String authorizationHeader = request.getHeader("Authorization");

		String token = null;
		String userName = null;

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			token = authorizationHeader.substring(7);
			userName = jwtUtil.extractUsername(token);
		}
		//Obtiene el contexto de authentication 
		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = service.loadUserByUsername(userName);
			
			//Valida el token
			if (jwtUtil.validateToken(token, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		//Filtra la peticion
		filterChain.doFilter(request, response);
	}
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CustomUserDetailsService service;

}
