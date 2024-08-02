package TDALista;
/**
 * Clase InvalidPositionException extiende Exception.
 * @author Juan Cruz Feuilles y Juan Pablo Ziegler.
 *
 */
public class InvalidPositionException extends Exception {
	
	/**
	 * Crea una nueva InvalidPositionException a partir de un String pasado por parámetros.
	 * @param s mensaje que se mostrará al lanzar la excepción.
	 */
	
	public InvalidPositionException(String s){super(s);}

}
