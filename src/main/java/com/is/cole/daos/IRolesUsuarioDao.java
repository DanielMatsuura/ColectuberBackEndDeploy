package com.is.cole.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.is.cole.entities.RoleUsuario;

@Repository
public interface IRolesUsuarioDao extends JpaRepository<RoleUsuario, Integer> {
	@Query("SELECT u FROM RoleUsuario u WHERE u.usuarios.id = ?1 AND u.roles.id = ?2")
	public RoleUsuario findByUsuarioIdRoleId(Integer usuarioId, Integer roleId);
	
	@Query("SELECT u FROM RoleUsuario u WHERE u.usuarios.id = ?1")
	public List<RoleUsuario> findByUsuarioId(Integer usuarioId);
	
	
}
