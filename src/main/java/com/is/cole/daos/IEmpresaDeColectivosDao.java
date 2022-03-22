package com.is.cole.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.cole.entities.EmpresaDeColectivos;

@Repository
public interface IEmpresaDeColectivosDao extends JpaRepository<EmpresaDeColectivos, Integer> {

}
