package TDALista;
/**
 * Clase InvalidPositionException extiende Exception.
 * @author Juan Cruz Feuilles y Juan Pablo Ziegler.
 *
 */
public class InvalidPositionException extends Exception {
	
	/**
	 * Crea una nueva InvalidPositionException a partir de un String pasado por par�metros.
	 * @param s mensaje que se mostrar� al lanzar la excepci�n.
	 */
	
	public InvalidPositionException(String s){super(s);}

}
