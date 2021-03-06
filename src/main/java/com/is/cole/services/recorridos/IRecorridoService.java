package com.is.cole.services.recorridos;

import com.is.cole.dtos.Result;
import com.is.cole.dtos.recorridos.RecorridoDto;

public interface IRecorridoService {
	//Cruds normales
	public RecorridoDto saveRecorrido(RecorridoDto dto);
	public RecorridoDto getRecorrido(Integer id);
	public void deleteRecorrido(Integer id);
	public Result<RecorridoDto> getAllRecorrido();

}
