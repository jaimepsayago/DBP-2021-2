package pucese.edu.web;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //tabla utilizando jpa
@Table(name="Autor") //agregar un nombre a la entidad = tabla
public class Autor {
	
	//id = primary key = campo que autogenere
	@Id //esta anotacion crea un PK para el campo que estoy generando
	@GeneratedValue(strategy=GenerationType.IDENTITY) //generar automaticamente los valores del campo
	@Column(name="autor_id") //agrega un nombre a la columna
	Long id; //la columna id = pk = autogenerada
	
	@Column(nullable = true) //las columnas no pueden ser nulas
	private String correo;
	@Column(nullable = true) //las columnas no pueden ser nulas
	private String nombre;
	
	//constructor
	public Autor() {
		
	}
	
	//constructor
	public Autor(String nombre, String correo) {
		this.nombre=nombre;
		this.correo=correo;
	}
	
	
	//relacion de autor y mensaje
	//construir las relaciones se tiene 3 tipos
	//one to many = uno a muchos
	//many to one = muchos a uno
	// many to many = muchos a muchos
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL) //mapeio de la relacion hacia la tabla Mensaje
	private Set<Mensaje> mensajes = new HashSet<Mensaje>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(Set<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", correo=" + correo + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
	

}
