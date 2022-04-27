package com.is.cole.dtos.colectuber;

import com.is.cole.dtos.BaseDto;
import com.is.cole.dtos.colectivos.ColectivoDto;
import com.is.cole.dtos.recorridos.RecorridoDto;

public class InitialViajeDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	private ColectivoDto colectivo;
	private RecorridoDto recorrido;
	
	public ColectivoDto getColectivo() {
		return colectivo;
	}
	public void setColectivo(ColectivoDto colectivo) {
		this.colectivo = colectivo;
	}
	public RecorridoDto getRecorrido() {
		return recorrido;
	}
	public void setRecorrido(RecorridoDto recorrido) {
		this.recorrido = recorrido;
	}
	
	
	
}
