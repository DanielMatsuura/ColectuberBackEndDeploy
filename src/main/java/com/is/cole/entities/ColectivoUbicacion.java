package com.is.cole.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "ubicaciones")
public class ColectivoUbicacion implements BaseBean{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable = false, unique = true)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="colectivo_id",referencedColumnName="id")
	private Colectivo colectivo;
	
	private Double latitud;
	private Double longitud;
	private Long tiempo;
	private String destino;
	
	@ManyToOne
	@JoinColumn(name="recorrido_id",referencedColumnName="id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Recorrido recorrido;
	
	private double indicePorcentaje;

	public double getIndicePorcentaje() {
		return indicePorcentaje;
	}
	public void setIndicePorcentaje(double indicePorcentaje) {
		this.indicePorcentaje = indicePorcentaje;
	}
	public Recorrido getRecorrido() {
		return recorrido;
	}
	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}
	public Colectivo getColectivo() {
		return colectivo;
	}
	public void setColectivo(Colectivo colectivo) {
		this.colectivo = colectivo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getLat() {
		return latitud;
	}
	public void setLat(Double lat) {
		this.latitud = lat;
	}
	public Double getLng() {
		return longitud;
	}
	public void setLng(Double lng) {
		this.longitud = lng;
	}
	public Long getTime() {
		return tiempo;
	}
	public void setTime(Long time) {
		this.tiempo = time;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
	

}
