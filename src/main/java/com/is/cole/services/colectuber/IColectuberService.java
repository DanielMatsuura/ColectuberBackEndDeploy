package com.is.cole.services.colectuber;

import com.is.cole.dtos.Result;
import com.is.cole.dtos.colectuber.ColectivoUbicacionDto;
import com.is.cole.dtos.colectuber.InitialDataDto;
import com.is.cole.dtos.colectuber.InitialViajeDto;
import com.is.cole.dtos.colectuber.UsuarioChoferDto;

public interface IColectuberService {
	public void postColectivoUbicacion(ColectivoUbicacionDto dto,String choferUsername);
	public Result<ColectivoUbicacionDto> getColectivosUbicacion(); 
	public InitialDataDto getInitialData();	
	public UsuarioChoferDto getChofer(String choferUsername);
	public InitialViajeDto getViaje(String choferUsername);
	
	
}
