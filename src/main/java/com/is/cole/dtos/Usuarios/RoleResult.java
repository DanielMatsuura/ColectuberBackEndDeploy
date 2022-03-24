package com.is.cole.dtos.Usuarios;

import java.util.List;

import com.is.cole.dtos.BaseDto;

public class RoleResult extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	private List<RoleDto> roles;

	public List<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}
	
}
