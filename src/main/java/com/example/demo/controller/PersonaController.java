package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AuthRespondeDTO;
import com.example.demo.DTO.PersonaDTO;
import com.example.demo.entity.Persona;
import com.example.demo.entity.Rol;
import com.example.demo.serviceImpl.PersonaServiceImpl;

@RestController
@RequestMapping("/api/persona")
@CrossOrigin(origins = "http://localhost:4200/")
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
	public AuthRespondeDTO login(@RequestBody Map<String, Object> persona){
		String nombres = (String) persona.get("nombres");
	    String apellidos = (String) persona.get("apellidos");
	    String dni = (String) persona.get("dni");
	    String correo = (String) persona.get("correo");
	    String codigo = (String) persona.get("codigo");
	    String username = (String) persona.get("username");
	    String password = (String) persona.get("password");
	    int fkRolId = (int) persona.get("idRol");
		Rol rol = new Rol(fkRolId, null);
		System.out.println(username+"--"+password);
		Persona create = new Persona(nombres, apellidos, dni, correo, codigo, username, password, rol);
		System.out.println(create.getPassword() + " - "+  create.getUsername() + " - "+ create.getNombres() 
		+ " - "+ create.getApellidos());
		return service.register(create)	;	
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
