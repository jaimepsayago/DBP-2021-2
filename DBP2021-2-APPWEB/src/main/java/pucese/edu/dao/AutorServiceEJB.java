package pucese.edu.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pucese.edu.model.Autor;

@Stateless
public class AutorServiceEJB extends AbstractPersistence<Autor, Long> implements AutorService{



	//implementar la jpa
	@PersistenceContext
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	//constructor
	public AutorServiceEJB() {
		super(Autor.class);
		// TODO Auto-generated constructor stub
	}

}
