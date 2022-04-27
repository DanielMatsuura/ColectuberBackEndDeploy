package com.is.cole.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.is.cole.entities.Viaje;

@Repository
public interface IViajeDao extends JpaRepository<Viaje,Integer>{

	@Query("SELECT u FROM Viaje u WHERE u.usuario.id = ?1")
	public Viaje findByUsuarioId(Integer usuarioId);
	
	@Query("SELECT u FROM Viaje u WHERE u.usuario.correo = ?1")
	public Viaje findByUsername(String choferUsername);
}
