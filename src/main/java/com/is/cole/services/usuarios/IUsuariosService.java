package com.is.cole.services.usuarios;

import com.is.cole.dtos.Usuarios.RoleDto;
import com.is.cole.dtos.Usuarios.RoleResult;
import com.is.cole.dtos.Usuarios.UsuarioDto;


public interface IUsuariosService {
	
	//Usuarios
	public UsuarioDto saveUsuario(UsuarioDto dto);
	public void deleteUsuario(Integer id);
	public UsuarioDto getUsuario(Integer id);
	
	//Roles
	public RoleDto saveRole(RoleDto dto);
	public RoleDto getRole(Integer id);
	public void deleteRole(Integer id);
	public RoleResult getAllRole();
	
	public void agregarRoleAUsuario(Integer userId, Integer roleId);
	public void agregarRoleAUsuario(Integer userId, String roleName);
	
	public void quitarRoleAUsuario(Integer userId, Integer roleId);
	public void quitarRoleAUsuario(Integer userId, String roleName);
	
	public Boolean isUsuarioRole(Integer userId,Integer roleId);
	public Boolean isUsuarioRole(Integer userId,String roleName);
}
