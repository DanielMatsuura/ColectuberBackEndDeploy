package com.is.cole.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Entidad para referenciar un punto de un recorrido con el siguiente punto
 * del recorrido
 * @author Colectuber
 */
@Entity
@Table(name="puntos_recorrido")
public class PuntoDeRecorrido implements BaseBean{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique= true)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="parada_id",referencedColumnName="id")
	private Parada parada;
	
	@OneToOne
	@JoinColumn(name="sig_punto_id",referencedColumnName="id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private PuntoDeRecorrido sig_punto;
	
	private Double latitud;
	private Double longitud;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Parada getParada() {
		return parada;
	}
	public void setParada(Parada parada) {
		this.parada = parada;
	}
	public PuntoDeRecorrido getSig_punto() {
		return sig_punto;
	}
	public void setSig_punto(PuntoDeRecorrido sig_punto) {
		this.sig_punto = sig_punto;
	}
	public Double getLatitud() {
		return latitud;
	}
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	
}
