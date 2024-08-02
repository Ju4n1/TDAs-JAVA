package TDALista;

/**
 * Clase EmptyListException extiende Exception.
 * @author Juan Cruz Feuille y Juan Pablo Ziegler.
 *
 */

public class EmptyListException extends Exception {
	
	
	/**
	 * Crea una nueva EmptyListException a partir de un String pasado por par�metros.
	 * @param s mensaje que se mostrar� a lanzar la excepci�n.
	 */
	
	public EmptyListException(String s){super(s);}

}
