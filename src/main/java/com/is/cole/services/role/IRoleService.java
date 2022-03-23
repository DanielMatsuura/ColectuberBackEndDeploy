package com.is.cole.services.role;

import com.is.cole.dtos.role.RoleDto;
import com.is.cole.dtos.role.RoleUsuarioDto;

public interface IRoleService {
	public RoleDto saveRole(RoleDto dto);
	public void deleteRole(Integer id);
	public RoleUsuarioDto agregarRoleAUsuario(RoleUsuarioDto dto);
	public void quitarRoleAUsuario(Integer roleUserId);
}
