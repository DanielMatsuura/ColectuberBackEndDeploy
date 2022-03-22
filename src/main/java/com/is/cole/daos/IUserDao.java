package com.is.cole.daos;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.cole.entities.Usuarios;

@Repository
public interface IUserDao extends JpaRepository<Usuarios, Integer> {
	

}
