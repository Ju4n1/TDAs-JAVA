package TDALista;
/**
 * Clase BoundaryViolationException extiende Exception.
 * @author Juan Cruz Feuille y Juan Pablo Ziegler
 *
 */
public class BoundaryViolationException extends Exception {

/**
 * Crea una nueva BoundaryViolationException a partir del String pasado por parámetros.
 * @param s mensaje que se mostrará al lanzar la excepción.
 */
	
public BoundaryViolationException(String s){super(s);}
}
