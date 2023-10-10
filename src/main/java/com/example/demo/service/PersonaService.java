package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Persona;

public interface PersonaService {
	
	List<Persona> readAll();
	Persona findById(int id);
	void delete (int id);
	void update(Persona p);
	void create(Persona p);
}
