package com.is.cole.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.cole.entities.Parada;

@Repository
public interface IParadaDao extends JpaRepository<Parada, Integer> {

}
