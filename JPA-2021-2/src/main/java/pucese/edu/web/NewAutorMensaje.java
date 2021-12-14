package pucese.edu.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;





public class NewAutorMensaje {

	public static void main(String[] args) {
		// agregar el objeto a utilizar
		String nombre=null, email = null;
		
		//Autor autor;
		
		//crear la factoria junto con un entity manager hacia la entidad principal
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		EntityManager em = emf.createEntityManager();
		
		//transaccionalidad
em.getTransaction().begin();
		
		//pedir los datos del autor
		
		nombre = leerTexto("introduce el nombre");
		email = leerTexto("introduce el correo");
		Autor autor = new Autor(nombre, email);
		
		//agregar o guardar los datos en la bdd con jpa hibernate
		em.persist(autor);
		
		//agregar los datos del mensaje
		String mensajeString = leerTexto("introduce el mensaje");
		
		Mensaje mensaje = new Mensaje(mensajeString,new Date(), autor);
		
		//agregar fecha
		//mensaje.setFecha(new Date());
		em.persist(mensaje);
		
//guardar transaccinalidad
		em.getTransaction().commit();
		
		//cerrramos la entity y la factoria
		em.close();
		emf.close();
		

	}
	
	public static String leerTexto(String mensaje) {
		String texto;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(mensaje);
			texto = in.readLine();
		} catch (IOException e) {
			texto = "error";
		}
	return texto;
	}

}
