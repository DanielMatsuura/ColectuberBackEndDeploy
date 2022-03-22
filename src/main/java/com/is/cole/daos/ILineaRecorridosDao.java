package com.is.cole.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.cole.entities.LineaRecorridos;

@Repository
public interface ILineaRecorridosDao extends JpaRepository<LineaRecorridos, Integer> {

}
