package com.is.cole.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter.ReferrerPolicy;

import com.is.cole.filter.JwtFilter;
import com.is.cole.services.userDetails.CustomUserDetailsService;

/**
 * Configuracion para la autenticacion, autorizacion y security headers de la aplicacion
 * @author Colectuber
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * Configuracion de los security headers
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http = http.csrf().disable();

		// Set session management to stateless
		http = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();

		http.authorizeRequests().antMatchers("/authenticate").permitAll();

		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		
		http
			.headers()
			.xssProtection()
			.and()
			.contentSecurityPolicy("default-src 'self';"
					+ "script-src 'report-sample' 'self';"
					+ "style-src 'report-sample' 'self';"
					+ "object-src 'none';"
					+ "base-uri 'self';"
					+ "connect-src 'self';"
					+ "font-src 'self';"
					+ "frame-src 'self';"
					+ "img-src 'self';"
					+ "manifest-src 'self';"
					+ "media-src 'self';"
					+ "report-uri https://626941b31e8c404e5a8b9dc6.endpoint.csper.io/?v=3;"
					+ "worker-src 'none';")
			.and()
			.referrerPolicy(ReferrerPolicy.STRICT_ORIGIN)
			.and()
			.permissionsPolicy(permissions -> permissions
					.policy("fullscreen=(), "
							+ "geolocation=(),"
							+ "camera=()"));
	}
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private JwtFilter filter;


}
