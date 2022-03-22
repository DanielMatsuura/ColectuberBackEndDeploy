package com.is.cole.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.cole.entities.Recorrido;

@Repository
public interface IRecorridoDao extends JpaRepository<Recorrido, Integer> {

}
