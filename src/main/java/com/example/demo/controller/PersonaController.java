package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DTO.PersonaDTO;
import com.example.demo.entity.Persona;
import com.example.demo.serviceImpl.PersonaServiceImpl;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
	
	@Autowired
	private PersonaServiceImpl service;
	
	@GetMapping("/all")
	public List<PersonaDTO> getAllPersonas(){
		List<Persona> listPersona = service.readAll();
		List<PersonaDTO> listDTO = new ArrayList<>();
		for (Persona persona : listPersona) {
		    PersonaDTO personaDTO = new PersonaDTO();
		    personaDTO.setIdpersona(persona.getIdpersona());
		    personaDTO.setNombres(persona.getNombres());
		    personaDTO.setApellidos(persona.getApellidos());
		    personaDTO.setCodigo(persona.getCodigo());
		    personaDTO.setDni(persona.getDni());
		    personaDTO.setCorreo(persona.getCorreo());
		    personaDTO.setIdRol(persona.getRol().getIdrol());
		    listDTO.add(personaDTO);
		}
		return listDTO;
	}
	
	@PostMapping("/create")
	public void login(@RequestBody Persona persona){
		service.create(persona);	
	}
	
	@DeleteMapping("/delete/{id}")
	public void login(@PathVariable(name = "id") int id){
		service.delete(id);	
	}
	
	@GetMapping("/search/{id}")
	public PersonaDTO getPerson(@PathVariable("id") int id){
		Persona personaSearch = service.findById(id);
		PersonaDTO listDTO = new PersonaDTO(personaSearch.getIdpersona(),personaSearch.getNombres(),personaSearch.getApellidos(),personaSearch.getDni(),
				personaSearch.getCorreo(),personaSearch.getCodigo(),personaSearch.getRol().getIdrol());
		return listDTO;
	}
}
