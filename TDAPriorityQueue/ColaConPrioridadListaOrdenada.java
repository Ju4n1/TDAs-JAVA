package TDAPriorityQueue;

import TDALista.*;

public class ColaConPrioridadListaOrdenada<K,V> implements PriorityQueue<K,V> {
	
	private PositionList<Entry<K,V>> lista;
	private Comparador<K> comparator;
	
	
public ColaConPrioridadListaOrdenada(Comparador<K>c){
	 lista=new DoubleLinkedList<Entry<K,V>>();
	 comparator=c;
	                            }
public int size(){return lista.size();}

public boolean isEmpty(){return lista.isEmpty();}

public Entry<K,V> min()throws EmptyPriorityQueueException{
	Entry<K,V>salida=null;
	if (lista.isEmpty())
		throw new EmptyPriorityQueueException("no puede pedir un elemento a una cola con prioridad vacia");
	try{
	salida= lista.first().element();
	   }
	catch(EmptyListException e1){System.out.println(e1.getMessage());}
	return salida;}



public Entry<K,V> removeMin()throws EmptyPriorityQueueException{
	    Entry<K,V> salida=null;
	    if(isEmpty())
	    	throw new EmptyPriorityQueueException("no se puede eliminar de una cola con prioridad vacia");
	    try{
	    	salida=lista.remove(lista.first());
	        }
	    catch(EmptyListException e1){System.out.println(e1.getMessage());}
	    catch(InvalidPositionException e2){System.out.println(e2.getMessage());}
	    
	    return salida;}

public void insert(K k, V v)throws InvalidKeyException{
	     checkKey(k);
	     Entrada<K,V>nuevo=new Entrada<K,V>(k,v);
	     if(isEmpty())
	    	 lista.addFirst(nuevo);
	     else{try{
	    	 Position<Entry<K,V>>pos=lista.first(); boolean seguir=true;
	    	 while(seguir){
	    	      if(comparator.compare(pos.element().getKey(),nuevo.getKey())>=0)
	    	    	  {lista.addBefore(pos,nuevo); seguir=false;}
	    	      else if(pos!=lista.last())
	    	    	      pos=lista.next(pos);
	    	            else {pos=null; seguir=false;}
	    	      }
	    	 if(pos==null&&seguir==false)
	    		 lista.addLast(nuevo);
	    	 }
	     catch(EmptyListException e1){}
	     catch(BoundaryViolationException e2){}
	     catch(InvalidPositionException e3){}
	     }
	     
	     
}

private void checkKey(K k)throws InvalidKeyException{
	   if(k==null)
		   throw new InvalidKeyException("clave invalida");}

}
