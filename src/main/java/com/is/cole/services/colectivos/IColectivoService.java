package com.is.cole.services.colectivos;

import com.is.cole.dtos.Result;
import com.is.cole.dtos.colectivos.ColectivoDto;

public interface IColectivoService {
	
	public ColectivoDto saveColectivo(ColectivoDto dto);
	public ColectivoDto getColectivo(Integer id);
	public void deleteColectivo(Integer id);
	public Result<ColectivoDto> getAllColectivo();
}
