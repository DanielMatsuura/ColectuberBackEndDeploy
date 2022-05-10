package com.is.cole.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.cole.entities.Color;

@Repository
public interface IColorDao extends JpaRepository<Color, Integer> {

	public Color findByNombre(String nombre);
	
}
