package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "rol")
public class Rol {
	
	@Id
	@Column(name="idrol")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrol;
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idrol")
	private List<Rol_Acceso> rol_acceso;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
	private List<Persona> personas;
	
	
}
