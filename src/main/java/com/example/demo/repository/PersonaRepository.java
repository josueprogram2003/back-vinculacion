package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	
	/* @Query(value = "{CALL LOGIN(:user, :password)}", nativeQuery = true)
	 Persona login(@Param("user") String user, @Param("password") String password);*/
	Optional<Persona> findByUsername(String username); 
}
