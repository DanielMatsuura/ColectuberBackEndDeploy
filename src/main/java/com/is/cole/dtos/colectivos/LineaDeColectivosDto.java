package com.is.cole.dtos.colectivos;

import com.is.cole.dtos.BaseDto;

public class LineaDeColectivosDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String numero;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
