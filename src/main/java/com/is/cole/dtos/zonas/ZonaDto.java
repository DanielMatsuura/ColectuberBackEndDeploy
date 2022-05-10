package com.is.cole.dtos.zonas;

import com.is.cole.dtos.BaseDto;

/**
 * Dto para zonas de paradas
 * @author Colectuber
 */
public class ZonaDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private String descripcion;
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
