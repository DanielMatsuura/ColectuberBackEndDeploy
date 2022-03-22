package com.is.cole.dtos.colectuber;

import com.is.cole.dtos.BaseDto;

public class ColectivoUbicacionDto extends BaseDto{
	private static final long serialVersionUID = 1L;
	
	private PosicionDto posicionColectivo;
	
	private Integer colectivoId;

	public PosicionDto getPosicionColectivo() {
		return posicionColectivo;
	}

	public void setPosicionColectivo(PosicionDto posicionColectivo) {
		this.posicionColectivo = posicionColectivo;
	}

	public Integer getColectivoId() {
		return colectivoId;
	}

	public void setColectivoId(Integer colectivoId) {
		this.colectivoId = colectivoId;
	}
	
	

}
