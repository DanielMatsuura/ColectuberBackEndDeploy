package com.is.cole.dtos.colectuber;

import java.util.List;

import com.is.cole.dtos.BaseDto;

public class ColectivoUbicacionResult extends BaseDto{

	private static final long serialVersionUID = 1L;
	private List<ColectivoUbicacionDto> listaColectivoUbicaciones;
	
	public List<ColectivoUbicacionDto> getListaColectivoUbicaciones() {
		return listaColectivoUbicaciones;
	}
	public void setListaColectivoUbicaciones(List<ColectivoUbicacionDto> listaColectivoUbicaciones) {
		this.listaColectivoUbicaciones = listaColectivoUbicaciones;
	}
	
	

}
