package com.is.cole.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.is.cole.entities.ColectivoUbicacion;

@Repository
public interface IColectivoUbicacionDao extends JpaRepository<ColectivoUbicacion, Integer> {

}
