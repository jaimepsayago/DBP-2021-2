package pucese.edu.dao;

import java.util.List;

import javax.ejb.Local;

import pucese.edu.model.Autor;

@Local
public interface AutorService {
	//crud
	public Autor save(Autor a);
	public void remove(Autor a);
	public Autor find(Long id);
	public Autor findObject(Autor id);
	public List<Autor> findAll();
	

}
