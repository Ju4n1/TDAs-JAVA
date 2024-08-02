package TDADiccionario;


import TDAPriorityQueue.Entry;


public interface Dictionary<K,V> {

	
/**
 * Cantiedad de entradas que posee el diccionario	
 * @return numero de entradas
 */
	
public int size();	

/**
 * Consulta si el diccionario esta vacio.
 * @return retorna verdadero si el diccionario está vacio, y falso si no lo está.
 */
public boolean isEmpty();
	
/**
 * Si el diccionario posee una entrada de clave K la retorna sino retorna null.
 * @param k clave que se decea encontar,
 * @return
 */

public Entry<K,V> find(K k);

/**
 * Si el diccionario posee entradas on clave k las retorna todas en una coleccion iterable.
 * @param k clave que se desea encontrar.
 * @return coleccion iterable de entradas con clave k.
 */

public Iterable<Entry<K,V>> findAll(K k);

/**
 * Inserta en el diccionario una nueva entrada con clave k y valor v.
 * @param k clave de la entrada nueva.
 * @param v valor de la nueva entrada.
 * @return retorna la entrada nueva.
 */
public Entry<K,V> insertar(K k,V v);


/**
 * Si el diccionario posee una entrada e, la elimina.
 * @param e entrada que desea eliminar.
 * @return si se encontro la entrada se elimina y se retorna, sino se encuentra la entrada se retorna null.
 * @throws NoExcistenEntryException en caso de no existir la entrada se lanza la excepcion.
 */
public Entry<K,V> remover(Entry<K,V>e)throws NoExcistenEntryException;


/**
 * Retorna una coleccion Iterable con todas las entradas del diccionario.
 * @return coleccion itrarable de entradas.
 */
public Iterable<Entry<K,V>> entris();
}
