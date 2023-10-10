package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "acceso")
public class Acceso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idacceso")
	private int idacceso;
	@Column(name = "ruta")
	private String ruta;
	@Column(name = "priority")
	private String priority;
	@Column(name = "title")
	private String title;
	@ManyToOne
    @JoinColumn(name = "idsubmenu", referencedColumnName = "idacceso")
    private Acceso idsubmenu;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idacceso")
	@NotNull
	private List<Rol_Acceso> rol_acceso;
}
