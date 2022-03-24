package com.is.cole.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.is.cole.entities.Roles;

@Repository
public interface IRoleDao extends JpaRepository<Roles, Integer> {
	@Query("SELECT u FROM Roles u WHERE u.nombre = ?1")
	public Roles findByName(String key);
	
}
