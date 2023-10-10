package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Persona;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;


@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository repo;
	
	
	@Override
	public List<Persona> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	@Override
	public Persona findById(int id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}


	@Override
	public void update(Persona p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}


	@Override
	public void create(Persona p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	

	


	
	
}
