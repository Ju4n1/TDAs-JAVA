package TDALista;



import java.util.*;

/**
 * Clase ElementIterator implementa Iterator.
 * @author Juan Cruz Feuilles y Juan Pablo Ziegler.
 *
 * @param <E> parámetro genérico de la clase.
 */

public class ElementIterator<E> implements Iterator<E> {

	
protected PositionList<E> list;	
	
protected Position<E> cursor; 


/**
 * Crea y prepara para recorrer un elemento iterador a partir de un lista de posiciones pasada por parámetros. 
 * @param l PositionList a partir de la cual se quiere crear el iterador.
 * @throws EmptyListException controla que no se produzca una situación de error al asignar el cursor.
 */

public ElementIterator(PositionList<E>l)throws EmptyListException{
	list=l;
	if(list.isEmpty())
		cursor=null;
	else cursor=list.first();}


/**
 *Consulta si hay elemento en el cursor.
 */

public boolean hasNext(){return cursor!=null;}


/**
 *Retorna el rotulo del elemento que se encuentra en el cursor.
 *@throws NoSuchElementException se lanza cuando el cursor posee un elemento nulo, es decir el iterador no tiene siguiente elemento.
 */

public E next() throws NoSuchElementException {
	if ( cursor == null )
		throw new NoSuchElementException ("no tiene siguiente");
	E toReturn = cursor.element();
try {
	if (cursor == list.last())
		cursor = null;
	else
		cursor = list.next(cursor);
} catch (EmptyListException | InvalidPositionException
		| BoundaryViolationException e) {
	e.printStackTrace();
}
return toReturn;
}

/**
 * 
 */
public void remove(){}
	
}
