package pucese.edu.web;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class TestBdd {
	
	//testing de la base de datos
	//crearla con el testing
	//generen todas las tablas que tengo construidas en la aplicacion
	
	@Test
	public void createEntityManagerTest() {
		//crear objeto de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		EntityManager em = emf.createEntityManager();
		
		//prueba 
		assertNotNull(em);
		
		em.close();
		
	}
	
	
	

}
