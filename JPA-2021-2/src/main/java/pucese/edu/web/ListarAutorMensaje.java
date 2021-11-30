package pucese.edu.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ListarAutorMensaje {
	//consulta para buscar los mensajes sin parametros
			private static final String query_Buscar_Mensajes = "Select m from Mensaje m"	;
			
	//consulta para buscar los autores
			private static final String query_Buscar_Autores = "Select m from Autor m"	;
			
	public static void main(String[] args) {
		
		//factoria
		//crear objeto de persistencia
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
				EntityManager em = emf.createEntityManager();
				
				//consulta de mensajes
				Query query = em.createQuery(query_Buscar_Mensajes); //query me permite hacer consultas
				
				//consulta de autor
				Query query2 = em.createQuery(query_Buscar_Autores); 
				
				List<Autor> autores = query2.getResultList();
				if(autores.isEmpty()){
					System.out.println("no existen datos de autores");
				}else {
					System.out.println("----------------datos de autores");
					for (Autor a: autores)
						System.out.println(a.toString());
				}
				
				
				//crear una lista con la informacion de la query o soncuslta
				List<Mensaje> mensajes = query.getResultList();
				
				if(mensajes.isEmpty()){
					System.out.println("no existen datos de mensajes");
				}else {
					System.out.println("----------- datos de mensajes");
					for (Mensaje var: mensajes)
						System.out.println(var.toString());
				}
		//cerrar el entity y la factoria
				em.close();
			emf.close();
				
		

	}

}
