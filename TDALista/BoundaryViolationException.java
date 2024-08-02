package TDALista;
/**
 * Clase BoundaryViolationException extiende Exception.
 * @author Juan Cruz Feuille y Juan Pablo Ziegler
 *
 */
public class BoundaryViolationException extends Exception {

/**
 * Crea una nueva BoundaryViolationException a partir del String pasado por par�metros.
 * @param s mensaje que se mostrar� al lanzar la excepci�n.
 */
	
public BoundaryViolationException(String s){super(s);}
}
