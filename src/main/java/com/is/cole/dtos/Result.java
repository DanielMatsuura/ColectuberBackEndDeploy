package com.is.cole.dtos;

import java.util.List;

/**
 * Dto utilizado para representar una lista de cualquier tipo de elemento que extienda de
 * BaseDto
 * @author Acer
 * @param <DTO>
 */
public class Result<DTO extends BaseDto> extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	private List<DTO> result;

	public List<DTO> getResult() {
		return result;
	}

	public void setResult(List<DTO> result) {
		this.result = result;
	}
	
	

}
