package com.is.cole.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.cole.entities.Roles;

@Repository
public interface IRoleDao extends JpaRepository<Roles, Integer> {
	
	
}
