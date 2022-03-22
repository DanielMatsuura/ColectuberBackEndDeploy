package com.is.cole.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.cole.entities.Colectivo;

@Repository
public interface IColectivoDao extends JpaRepository<Colectivo, Integer> {

}
