package com.is.cole.services.colectuber;

import com.is.cole.dtos.colectuber.ColectivoUbicacionDto;
import com.is.cole.dtos.colectuber.ColectivoUbicacionResult;

public interface IColectuberService {
	public void postColectivoUbicacion(ColectivoUbicacionDto dto);
	public ColectivoUbicacionResult getColectivosUbicacion(); 
}
