package com.is.cole.dtos.colectuber;

import com.is.cole.dtos.BaseDto;

/**
 * Dto para representar un colectivo con sus datos completos
 * @author Colectuber
 */
public class ColectuberColectivoDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String empresa;
	private String linea;
	private String numero;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	
	
	
	
}
