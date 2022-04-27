package com.is.cole.dtos.paradas;

import com.is.cole.dtos.BaseDto;
import com.is.cole.dtos.PosicionDto;

public class ParadaDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nombre;
	
	private String descripcion;
	
	private String image;
	
	private PosicionDto posicion;

	
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public PosicionDto getPosicion() {
		return posicion;
	}

	public void setPosicion(PosicionDto posicion) {
		this.posicion = posicion;
	}


	
}
