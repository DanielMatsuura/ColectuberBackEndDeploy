package com.is.cole.dtos.colectuber;

import com.is.cole.dtos.BaseDto;

/**
 * Dto que representa a un usuario chofer
 * @author Acer
 */
public class UsuarioChoferDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private String apellido;
	private String correo_electronico;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

}
