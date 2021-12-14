package pucese.edu.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the th_provincia database table.
 * 
 */
@Entity
@Table(name="th_provincia")
@NamedQuery(name="Provincia.findAll", query="SELECT p FROM Provincia p")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="\"descProvincia\"")
	private String descProvincia;

	@Column(name="\"idPais\"")
	private Integer idPais;

	//bi-directional many-to-one association to Canton
	@OneToMany(mappedBy="thProvincia")
	private List<Canton> thCantons;

	public Provincia() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescProvincia() {
		return this.descProvincia;
	}

	public void setDescProvincia(String descProvincia) {
		this.descProvincia = descProvincia;
	}

	public Integer getIdPais() {
		return this.idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public List<Canton> getThCantons() {
		return this.thCantons;
	}

	public void setThCantons(List<Canton> thCantons) {
		this.thCantons = thCantons;
	}

	public Canton addThCanton(Canton thCanton) {
		getThCantons().add(thCanton);
		thCanton.setThProvincia(this);

		return thCanton;
	}

	public Canton removeThCanton(Canton thCanton) {
		getThCantons().remove(thCanton);
		thCanton.setThProvincia(null);

		return thCanton;
	}

}