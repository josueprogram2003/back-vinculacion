package com.example.demo.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "rol_acceso")
public class Rol_Acceso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol_acceso")
	private int id_rol_acceso;
	
	/* el 
	 * Atributos dentro de joincolumn @JoinColumn
	 * 
	 * name: Es el nombre de la columna de la tabla que se va a crear
	 * referencedColumnName: Hace referencia al campo a la cual se quiere relacionar de la otra tabla
	 * 
	 * 2-
	 * private Acceso idacceso
	 * en esta parte el nombre "idacceso tiene que ser igual al que se encuentra en la otra clase para que se pueda hacer la relacion"
	 * */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@NotNull
	@JoinColumn(name = "id_acceso",referencedColumnName = "idacceso", nullable = false)
	private Acceso idacceso;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_rol",referencedColumnName = "idrol", nullable = false)
	private Rol idrol;
	
	
}
