package com.is.cole.dtos.role;

import com.is.cole.dtos.BaseDto;

public class RoleUsuarioDto extends BaseDto{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer roleId;
	private Integer usuarioId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
}
