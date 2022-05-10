package com.is.cole.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.cole.entities.Zona;

@Repository
public interface IZonaDao extends JpaRepository<Zona, Integer>{

	public Zona findByNombre(String nombre);
}
