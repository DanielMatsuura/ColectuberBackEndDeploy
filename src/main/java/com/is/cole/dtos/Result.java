package com.is.cole.dtos;

import java.util.List;

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
