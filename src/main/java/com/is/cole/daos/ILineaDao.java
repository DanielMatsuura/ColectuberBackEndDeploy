package com.is.cole.daos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.cole.entities.Linea;

@Repository
public interface ILineaDao extends JpaRepository<Linea, Integer> {

	
}
