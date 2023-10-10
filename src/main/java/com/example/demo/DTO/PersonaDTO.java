package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
	
	private int idpersona;
	private String nombres;
	private String apellidos;
	private String dni;
	private String correo;
	private String codigo;
	private int idRol;
	
	
}
