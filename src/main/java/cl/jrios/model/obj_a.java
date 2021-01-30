package cl.jrios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "obj_a")
public class obj_a {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEntidad;

	@Column(name = "nombre")
	private String nombre;

}
