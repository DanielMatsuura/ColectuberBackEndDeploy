package com.is.cole.services.zonas;

import com.is.cole.dtos.Result;
import com.is.cole.dtos.zonas.ZonaDto;

public interface IZonaService {

	public ZonaDto saveZona(ZonaDto dto);
	public ZonaDto getByIdZona(Integer id);
	public Result<ZonaDto> getAllZonas();
	public void deleteZona(Integer id);
}
