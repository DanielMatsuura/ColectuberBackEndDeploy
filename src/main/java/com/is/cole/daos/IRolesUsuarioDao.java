package com.is.cole.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.cole.entities.RoleUsuario;

@Repository
public interface IRolesUsuarioDao extends JpaRepository<RoleUsuario, Integer> {
	
}
