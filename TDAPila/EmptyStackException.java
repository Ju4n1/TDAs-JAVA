package TDAPila;
/**
 * Clase EmptyStackException extiende Exception.
 * @author Juan Pablo Ziegler, Juan Cruz Feuilles.
 *
 */
public class EmptyStackException extends Exception {
	
	
/**
 * Crea una nueva EmptyStackException a partir de un String pasado por parámetros.
 * @param s mensaje que se motrara al lanzar la Excepción.
 */
	
public EmptyStackException(String s){super(s);}

}
