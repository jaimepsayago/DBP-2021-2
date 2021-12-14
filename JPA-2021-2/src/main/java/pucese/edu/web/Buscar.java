package pucese.edu.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Buscar {

	private static final String QueryBusqueda = 
			"Select a from Autor a where a.nombre like :patron";
	
	public static void main(String[] args) {
		// busquedas con parametros utilziando jpql
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		//entitymanager
		EntityManager em = emf.createEntityManager();
		
		System.out.println("buscando el autor");
		String palabra = leerTexto("introduce una palabra");
		
		//agregar un id para la consulta
		String patron = "%" + palabra + "%";
		
		//consulta con la ejecucion del parametro patron
		
		Query query = em.createQuery(QueryBusqueda);
		query.setParameter("patron", patron);
		
		//crear una lidata con la informacion
		List<Autor> a = query.getResultList();
		if(a.isEmpty()) {
			System.out.println("no existen datos");
			
		}else {
			for (Autor dato:a) {
				System.out.println(dato.getNombre()+ "--" + dato.getId());
			}
		}

	}
	public static String leerTexto(String mensaje) {
		String texto;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print(mensaje);
			texto = in.readLine();
		} catch (IOException e) {
			texto = "error";
		}
	return texto;
	}

}
