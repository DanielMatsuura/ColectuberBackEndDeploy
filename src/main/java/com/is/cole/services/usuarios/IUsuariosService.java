package com.is.cole.services.usuarios;

import com.is.cole.dtos.Usuarios.UsuarioDto;

public interface IUsuariosService {
	public UsuarioDto saveUsuario(UsuarioDto dto);
	public void deleteUsuario(Integer id);
	public UsuarioDto getUsuario(Integer id);
}
