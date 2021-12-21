package pucese.edu.model;

import java.io.Serializable;

/**
 * 
 * @author JSH
 * este es un componente base de persistencia.
 * para la id de las entidades persistentes de la aplicacion
 */

public interface AbstractEntity extends Serializable {

	/**
	 * hace referencia a la clave primaria de cada objeto persistido
	 * y si no tiene dato retorna null
	 * @return
	 */
		public Long getId();
	
}
