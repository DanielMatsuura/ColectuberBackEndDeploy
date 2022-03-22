package com.is.cole.dtos.colectuber;

import com.is.cole.dtos.BaseDto;

public class PosicionDto extends BaseDto{
	private static final long serialVersionUID = 1L;
	
	private double latitud;
	private double longitud;
	
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	
	
	
}
