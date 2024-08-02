package TDALista;

/**
 * Clase EmptyListException extiende Exception.
 * @author Juan Cruz Feuille y Juan Pablo Ziegler.
 *
 */

public class EmptyListException extends Exception {
	
	
	/**
	 * Crea una nueva EmptyListException a partir de un String pasado por parámetros.
	 * @param s mensaje que se mostrará a lanzar la excepción.
	 */
	
	public EmptyListException(String s){super(s);}

}
