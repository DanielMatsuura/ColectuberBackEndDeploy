package com.is.cole.dtos.colectivos;

import com.is.cole.dtos.BaseDto;

public class ColectivoDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer empresaId;
	private Integer lineaId;
	private String numero;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(Integer empresaColectivoId) {
		this.empresaId = empresaColectivoId;
	}
	public Integer getLineaId() {
		return lineaId;
	}
	public void setLineaId(Integer lineaColectivoId) {
		this.lineaId = lineaColectivoId;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	

}
