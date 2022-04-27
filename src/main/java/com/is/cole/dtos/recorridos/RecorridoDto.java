package com.is.cole.dtos.recorridos;

import java.util.List;

import com.is.cole.dtos.BaseDto;

public class RecorridoDto extends BaseDto{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private List<PuntoDeRecorridoDto> puntos;
	
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
	public List<PuntoDeRecorridoDto> getPuntos() {
		return puntos;
	}
	public void setPuntos(List<PuntoDeRecorridoDto> puntos) {
		this.puntos = puntos;
	}
	
	

}
