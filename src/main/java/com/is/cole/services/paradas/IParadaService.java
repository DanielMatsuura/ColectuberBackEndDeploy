package com.is.cole.services.paradas;

import com.is.cole.dtos.Result;
import com.is.cole.dtos.paradas.ParadaDto;


public interface IParadaService {
	
	public ParadaDto saveParada(ParadaDto dto);
	public Result<ParadaDto> getAllParadas();
	public ParadaDto getParadaById(Integer id);
	public void deleteById(Integer id);
}
