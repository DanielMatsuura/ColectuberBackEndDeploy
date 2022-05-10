package com.is.cole.dtos.colores;

import com.is.cole.dtos.BaseDto;

public class ColorDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String color) {
		this.nombre = color;
	}

}
