package TDALista;

/**
 * Clase Nodo implementa la interfaz Position.
 * @author Juan cruz Feuilles y Juan Pablo Ziegler.
 *
 * @param <E> parámetro genérico de la clase.
 */

public class Nodo<E> implements Position<E> {

private E element; 

private Nodo<E> prev; 

private Nodo<E>next;

/**
 * Crea un nuevo nodo con rótulo, siguiente y previo pasador por parámetros.
 * @param elem rótulo del nuevo nodo.
 * @param n nodo siguiente al nodo nuevo.
 * @param p nodo previo al nodo nuevo.
 */

public Nodo(E elem, Nodo<E>n, Nodo<E>p){
	 prev=p;
	 element=elem;
	 next=n;}


public E element(){
   return element;}


/**
 * Retorna el nodo previo del nodo que resive el mensaje.
 * @return nodo previo.
 */
public Nodo<E> getPrev(){return prev;}

/**
 * Retorna el nodo siguiente del nodo que resive el mensaje.
 * @return nodo siguiente.
 */

public Nodo<E> getNext(){return next;}

/**
 * Cambia el rótulo del nodo que resive el mensaje.
 * @param item nuevo rótulo.
 */
	
public void setElement(E item){element=item;}

/**
 * Cambia el nodo previo al nodo que resive el mensaje.
 * @param p nuevo nodo previo.
 */

public void setPrev(Nodo<E>p){prev=p;}

/**
 * Cambia el nodo siguiente al nodo que resive el mensaje.
 * @param n nuevo nodo siguiente.
 */

public void setNext(Nodo<E>n){next=n;}

}
