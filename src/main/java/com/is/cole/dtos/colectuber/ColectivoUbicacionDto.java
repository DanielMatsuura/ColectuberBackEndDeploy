package com.is.cole.dtos.colectuber;

import com.is.cole.dtos.BaseDto;
import com.is.cole.dtos.PosicionDto;

/**
 * Dto para la ubicacion de un colectivo
 * @author Colectuber
 */
public class ColectivoUbicacionDto extends BaseDto{
	private static final long serialVersionUID = 1L;
	
	private PosicionDto posicionColectivo;
	private Integer colectivoId;
	private Double indicePorcentaje;
	private Integer recorrido_id;
	private Integer chofer_id;
	private String destino;
	
	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getChofer_id() {
		return chofer_id;
	}

	public void setChofer_id(Integer chofer_id) {
		this.chofer_id = chofer_id;
	}

	public Double getIndicePorcentaje() {
		return indicePorcentaje;
	}

	public void setIndicePorcentaje(Double indicePorcentaje) {
		this.indicePorcentaje = indicePorcentaje;
	}

	public Integer getRecorrido_id() {
		return recorrido_id;
	}

	public void setRecorrido_id(Integer recorrido_id) {
		this.recorrido_id = recorrido_id;
	}

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
