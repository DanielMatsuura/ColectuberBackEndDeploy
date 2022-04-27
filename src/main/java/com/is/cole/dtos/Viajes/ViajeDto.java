package com.is.cole.dtos.Viajes;

import com.is.cole.dtos.BaseDto;

public class ViajeDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer chofer_id;
	private Integer colectivo_id;
	private Integer recorrido_id;
	private String destino;
	private Integer estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getChofer_id() {
		return chofer_id;
	}

	public void setChofer_id(Integer chofer_id) {
		this.chofer_id = chofer_id;
	}

	public Integer getColectivo_id() {
		return colectivo_id;
	}

	public void setColectivo_id(Integer colectivo_id) {
		this.colectivo_id = colectivo_id;
	}

	public Integer getRecorrido_id() {
		return recorrido_id;
	}

	public void setRecorrido_id(Integer recorrido_id) {
		this.recorrido_id = recorrido_id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	

}
