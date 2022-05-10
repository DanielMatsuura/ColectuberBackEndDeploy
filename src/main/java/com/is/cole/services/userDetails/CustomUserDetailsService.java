package com.is.cole.services.userDetails;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.is.cole.daos.IRolesUsuarioDao;
import com.is.cole.daos.IUserDao;
import com.is.cole.entities.Roles;
import com.is.cole.entities.Usuarios;

/**
 * Servicio utilizado para la autenticacion
 * @author Colectuber
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	/**
	 * Se obtiene un UserDetails por medio del username de un usuario
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Se obtiene el user y los roles 
		Usuarios user = userDao.findByCorreo(username);

		List<Roles> roles = rolesUsuarioDao.findByUsuarioId(user.getId()).stream()
				.map(roleUsuario -> roleUsuario.getRoles()).collect(Collectors.toList());
		
		List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.collect(Collectors.toList());
		
		//Se devuelve el user con el password y sus roles
		return new User(user.getCorreo(), user.getPassword(), authorities);
	}
	
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IRolesUsuarioDao rolesUsuarioDao;

}
