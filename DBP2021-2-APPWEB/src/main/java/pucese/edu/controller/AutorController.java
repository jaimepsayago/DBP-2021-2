package pucese.edu.controller;
/*
 * aqui se integra las distintas capas de la appweb
 * model - dao - controller -  vistas
 */


import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import pucese.edu.dao.AutorService;
import pucese.edu.model.Autor;

@Named
@RequestScoped
public class AutorController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//conectar con la capa negocio -  cdi context dependecy inyection
	@Inject
	private AutorService autorService;
	
	//objeto de tipo Autor
	private Autor autor;
	
	//listar los datos del autor
	List<Autor> list;
	
	
	//otras variables para los otros metodos
	private Autor selectedAutor;
	
	
	//constructor
	public AutorController() {
		if (autor == null) {
			autor = new Autor(); //si no existe el autor recien aqui me instancia el objeto
		}
	}


	public AutorService getAutorService() {
		return autorService;
	}


	public void setAutorService(AutorService autorService) {
		this.autorService = autorService;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public List<Autor> getList() {
		list = autorService.findAll();
		return list;
	}


	public void setList(List<Autor> list) {
		this.list = list;
	}


	public Autor getSelectedAutor() {
		return selectedAutor;
	}


	public void setSelectedAutor(Autor selectedAutor) {
		this.selectedAutor = selectedAutor;
	}
	
	//metodos
	
	//guardar
	public String guardar() {
		
		try {
			System.out.println("service: " + autorService); //controlor de datos
			autorService.save(autor);
			
		} catch (Exception e) {
			System.out.println("error" + e.getMessage());
			return "";
		}
		
		return "listarAutorPrimefaces";
	}
	
	//editar
	public void editar() {
		if(selectedAutor == null) {
			return;
		}
		//buscar datos del autor por id
		Long id = Long.parseLong(selectedAutor.getId().toString());
		autor = autorService.find(id);
	}
	
	//eliminar
	public String remover(ActionEvent e) {
		try {
			autor = new Autor();
			String i= e.getComponent().getAttributes().get("itemEliminar").toString(); //obtenemos el parametro desde el dtatable
			Long dato = Long.parseLong(i);
			autor.setId(dato);
			autorService.remove(autor);
			
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "";
		}
		return "listarAutorPrimefaces";
	}
	

}
