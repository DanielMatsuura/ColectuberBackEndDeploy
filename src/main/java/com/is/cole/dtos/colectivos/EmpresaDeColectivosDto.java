package com.is.cole.dtos.colectivos;

import com.is.cole.dtos.BaseDto;

public class EmpresaDeColectivosDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private String direccion;
	private String numero_telefono;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNumero_telefono() {
		return numero_telefono;
	}
	public void setNumero_telefono(String numero_telefono) {
		this.numero_telefono = numero_telefono;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	
	
	
}
