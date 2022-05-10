package com.is.cole.services.viajes;

import com.is.cole.dtos.Result;
import com.is.cole.dtos.Viajes.ViajeDto;

public interface IViajesService{

	//CRUD normal
	public ViajeDto saveViaje(ViajeDto dto);
	public void deleteViaje(Integer id);
	public ViajeDto getViaje(Integer id);
	public Result<ViajeDto> getAllViajes();
	
	//Funciones especificas
	public ViajeDto getByChoferIdViaje(Integer id);
	
	
	
}
