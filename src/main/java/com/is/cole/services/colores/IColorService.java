package com.is.cole.services.colores;

import com.is.cole.dtos.Result;
import com.is.cole.dtos.colores.ColorDto;

public interface IColorService {

	public ColorDto saveColor(ColorDto dto);
	public Result<ColorDto> getAllColors();
	public ColorDto getColorById(Integer id);
	public void deleteById(Integer id);
	public ColorDto getByNombre(String nombre);
	
}
