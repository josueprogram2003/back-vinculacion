package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.AuthRespondeDTO;
import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.entity.Persona;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;
@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository repo;
	@Autowired
	private  PersonaRepository userRepository;
	@Autowired
	private  JwtServiceImpl jwtService;
	@Autowired
    private  PasswordEncoder passwordEncoder;
	@Autowired
    private  AuthenticationManager authenticationManager;
	
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
	
	// login and register
	
	
	
	public AuthRespondeDTO login(UsuarioDTO request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsuario()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthRespondeDTO.builder()
            .token(token)
            .build();

    }

    public AuthRespondeDTO register(Persona request) {
    	System.out.println(request.getPassword());
        Persona user = Persona.builder()
			    .username(request.getUsername())
			    .nombres(request.getNombres())
			    .apellidos(request.getApellidos())
			    .codigo(request.getCodigo())
			    .correo(request.getCorreo())
			    .dni(request.getDni())
			    .rol(request.getRol())
			    .password(passwordEncoder.encode(request.getPassword()))
			    .build();
		

        userRepository.save(user);

        return AuthRespondeDTO.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }

	

	


	
	
}
