package com.is.cole.services.lineas;

import com.is.cole.dtos.Result;
import com.is.cole.dtos.colectivos.LineaDeColectivosDto;

public interface ILineaColectivosService{
	public LineaDeColectivosDto saveLineaColectivo(LineaDeColectivosDto dto);
	public LineaDeColectivosDto getLineaColectivo(Integer lineaId);
	public void deleteLineaColectivo(Integer lineaId);
	public Result<LineaDeColectivosDto> getAllLineaColectivo();
}
