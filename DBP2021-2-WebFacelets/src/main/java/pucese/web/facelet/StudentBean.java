package pucese.web.facelet;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/*
 * MVC
 * CONTROLADOR
 * ESTA CLASE BEAN ES EL PUENTE ENTRE LA VISTA(FRONTEND-HTML) CON LA CAPA DEL MODELO (BDD)
 * ETIQUETAS O DECORADOS = SE LLAMA A LAS DISTINTAS OPCIONES DE ESTE TIPO DE TECNOLOGIA
 * JAVABEANS = CLASES DE JAVA PARA AGREGAR FUNCIONALIDAD ENTRE LA VISTA Y EL CONTROLADOR
 * 
 */
@Named // CDI o inyeccion de dependencia = conectar capas de una app web
@RequestScoped //manejo de sessiones en java 
public class StudentBean {
	
	private String nombre, apellido, direccion;
	
	public StudentBean() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	//imprimir los datos y enviar a una pagina web
	public String studentData() {
		System.out.println("Nombre: " + nombre + " " + "Apellido: " + " " + "Direccion: " + direccion);
		return "output";
		
	}
	
	//imprimir los datos y enviar a una pagina web coN BOOTSTRAP
		public String studentDataBoostrap() {
			System.out.println("Nombre: " + nombre + " " + "Apellido: " + " " + "Direccion: " + direccion);
			return "outputBootstrap";
			
		}

}
