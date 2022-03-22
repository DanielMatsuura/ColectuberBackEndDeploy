package com.is.cole.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.cole.entities.RolesUsuario;

@Repository
public interface IRolesUsuarioDao extends JpaRepository<RolesUsuario, Integer> {
	
}
