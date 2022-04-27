package com.is.cole.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="viajes",uniqueConstraints= {
		@UniqueConstraint(name="uk_usuario",columnNames = {"usuario_id"}),
		@UniqueConstraint(name="uk_colectivo",columnNames = {"colectivo_id"})
})
public class Viaje implements BaseBean{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="usuario_id",referencedColumnName="id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Usuarios usuario;
	
	@OneToOne
	@JoinColumn(name="colectivo_id",referencedColumnName="id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Colectivo colectivo;
	
	@ManyToOne
	@JoinColumn(name="recorrido_id",referencedColumnName="id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Recorrido recorrido;
	
	private String destino;
	
	private Long last_update;
	
	private Boolean terminado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Colectivo getColectivo() {
		return colectivo;
	}

	public void setColectivo(Colectivo colectivo) {
		this.colectivo = colectivo;
	}

	public Recorrido getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Long getLast_update() {
		return last_update;
	}

	public void setLast_update(Long last_update) {
		this.last_update = last_update;
	}

	public Boolean getTerminado() {
		return terminado;
	}

	public void setTerminado(Boolean terminado) {
		this.terminado = terminado;
	}
	
	

}
