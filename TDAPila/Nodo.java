package TDAPila;

/**
 * Clase Nodo
 * @author Juan Cruz Feuille y Juan Pablo Ziegler.
 * @param <E> parámetro genérico de la clase.
 */

public class Nodo<E> {
	
protected E element; 
protected Nodo<E> next;

/**
 * Crea un nuevo nodo con su respectivo rotulo y nodo siguiente pasados por parámetros.
 * @param elem rótulo del nuevo nodo.
 * @param n nodo siguiente al nodo nuevo.
 */

public Nodo(E elem, Nodo<E>n){
	     this.element=elem;
	     this.next=n;}

/**
 * Crea un nodo solo a partir de su rótulo pasado por parámetros.
 * @param elem rótulo de nodo nuevo.
 */


public Nodo(E elem){
   this(elem,null);}

/**
 * Retorna el rótulo del nodo que resive el mensaje.
 * @return rotulo del nodo.
 */

public E element(){
   return element;}

/**
 * Retorna el nodo siguiente al que resive el mensaje.
 * @return nodo siguiente.
 */
public Nodo<E> getNext(){return next;}

/**
 * Cambia el rótulo al nodo que resive el mensaje.
 * @param item nuevo rótulo.
 */

public void setElement(E item){element=item;}


/**
 * Cambia el nodo sigueinte al nodo que resivio el mensaje.
 * @param n nuevo nodo siguiente.
 */
public void setNext(Nodo<E>n){next=n;}

}
