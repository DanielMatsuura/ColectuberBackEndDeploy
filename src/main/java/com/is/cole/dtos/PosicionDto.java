package com.is.cole.dtos;

/**
 * Dto utilizado para representar la latitud y longitud
 * @author Colectuber
 */
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
