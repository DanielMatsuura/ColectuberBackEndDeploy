package com.is.cole.dtos.colectuber;

import java.util.List;
import com.is.cole.dtos.BaseDto;
import com.is.cole.dtos.paradas.ParadaDto;
import com.is.cole.dtos.recorridos.RecorridoDto;

/**
 * Dto para representar los datos iniciales que requiere la web 
 * @author Colectuber
 */
public class InitialDataDto extends BaseDto{

	private static final long serialVersionUID = 1L;

	private List<ColectuberColectivoDto> colectivos;
	
	private List<ParadaDto> paradas;
	
	private List<RecorridoDto> recorridos;
	
	private List<ColectivoUbicacionDto> colectivoUbicacion;
	
	public List<ColectuberColectivoDto> getColectivos() {
		return colectivos;
	}

	public void setColectivos(List<ColectuberColectivoDto> colectivos) {
		this.colectivos = colectivos;
	}

	public List<ParadaDto> getParadas() {
		return paradas;
	}

	public void setParadas(List<ParadaDto> paradas) {
		this.paradas = paradas;
	}

	public List<RecorridoDto> getRecorridos() {
		return recorridos;
	}

	public void setRecorridos(List<RecorridoDto> recorridos) {
		this.recorridos = recorridos;
	}

	public List<ColectivoUbicacionDto> getColectivoUbicacion() {
		return colectivoUbicacion;
	}

	public void setColectivoUbicacion(List<ColectivoUbicacionDto> colectivoUbicacion) {
		this.colectivoUbicacion = colectivoUbicacion;
	}
	
	

	
}
