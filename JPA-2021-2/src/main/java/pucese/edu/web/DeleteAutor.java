package pucese.edu.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteAutor {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		EntityManager em = emf.createEntityManager();
		
		//transaccionalidad
em.getTransaction().begin();

//introducir los datos a eliminar

System.out.println("eliminando autor");
String dato = leerTexto("introduce el id del autor: ");
Long id = new Long(dato); //cast 

//busqueda
Autor autor = em.find(Autor.class, id);

//eliminar
em.remove(autor);

em.getTransaction().commit();
emf.close();
em.close();

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
