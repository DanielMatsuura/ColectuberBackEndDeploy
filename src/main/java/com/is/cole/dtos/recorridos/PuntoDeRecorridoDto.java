package com.is.cole.dtos.recorridos;

import com.is.cole.dtos.BaseDto;
import com.is.cole.dtos.PosicionDto;

public class PuntoDeRecorridoDto extends BaseDto{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer paradaId;
	private PosicionDto puntoPosicion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParadaId() {
		return paradaId;
	}
	public void setParadaId(Integer paradaId) {
		this.paradaId = paradaId;
	}
	public PosicionDto getPuntoPosicion() {
		return puntoPosicion;
	}
	public void setPuntoPosicion(PosicionDto puntoPosicion) {
		this.puntoPosicion = puntoPosicion;
	}
	
	
	
	
}
