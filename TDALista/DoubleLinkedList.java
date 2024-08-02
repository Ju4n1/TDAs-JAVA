package TDALista;
import java.util.Iterator;

/**
 * Clase DoubleLinkedList implementa la interfaz PositionList.
 * @author Juan Cruz Feuilles Y Juan PAblo Ziegler.
 *
 * @param <E> parámetro genérico de la clase.
 */

public class DoubleLinkedList<E> implements PositionList<E> {

private Nodo<E>head;

private Nodo<E>tail;

private int size;

/**
 * Crea una lista vacia con los nodo centinelas head y tail nulos.
 */

public DoubleLinkedList(){
	head=new Nodo<E>(null,null,null);
	tail=new Nodo<E>(null,null,null);
	size=0;
    head.setNext(tail);
	tail.setPrev(head);
	                      }

public int size(){return size;}

public boolean isEmpty(){return size==0;}

public Position<E> first()throws EmptyListException{
	if(isEmpty())
		throw new EmptyListException("la lista esta vacia.......Lista.first()");
	 return head.getNext();}

public Position<E> last()throws EmptyListException{
	 if(isEmpty())
		 throw new EmptyListException("la lista esta vacia......Lista.last()");
	 return tail.getPrev();}

public Position<E> prev(Position<E>p)throws InvalidPositionException,BoundaryViolationException{
                Nodo<E>n=checkPosition(p);
                if (n.getPrev()==head)
                	throw new BoundaryViolationException("No se puede pedir elemento previo a la cabeza de la lista");
                return n.getPrev();}

public Position<E> next(Position<E>p)throws InvalidPositionException,BoundaryViolationException{
	            Nodo<E>n=checkPosition(p);
	            if(n.getNext()==tail)
	            	throw new BoundaryViolationException("no se puede pedir el siguiente elemento a la cola de la lista");
	            return n.getNext();}

public void addFirst(E item){
	     Nodo<E>n=new Nodo<E>(item,null,null);
	     n.setPrev(head);
	     n.setNext(head.getNext());
	     head.getNext().setPrev(n);
	     head.setNext(n); 
	     size++;}


public void addLast(E item){
	Nodo<E>n=new Nodo<E>(item,null,null);
	n.setNext(tail);
	n.setPrev(tail.getPrev());
	tail.getPrev().setNext(n);
	tail.setPrev(n);
	size++;}



public void addBefore(Position<E>p, E item)throws InvalidPositionException{
	          Nodo<E>nodo=checkPosition(p); 
	          Nodo<E> nuevo=new Nodo<E>(item,null,null);
	          nuevo.setNext(nodo);
	          nuevo.setPrev(nodo.getPrev());
	          nodo.getPrev().setNext(nuevo);
	          nodo.setPrev(nuevo);
	          size++;}



public void addAfter(Position<E>p, E item)throws InvalidPositionException{
            Nodo<E>nodo=checkPosition(p); 
            Nodo<E> nuevo=new Nodo<E>(item,null,null);
            nodo.getNext().setPrev(nuevo);
            nuevo.setNext(nodo.getNext());
            nuevo.setPrev(nodo);
            nodo.setNext(nuevo);
            size++;}


public E set(Position<E>p, E item)throws InvalidPositionException{
	          if(isEmpty())    
	          throw new InvalidPositionException("no se puede modificar una posicion de una listavacia");
	          Nodo<E>nodo=checkPosition(p);
	          E aux=nodo.element();
	          nodo.setElement(item);
	          return aux;}


public E remove(Position<E>p)throws InvalidPositionException{
	   if(isEmpty())
		   throw new InvalidPositionException(" no se puede eliminar una posicion de una lista vacia");
	   Nodo<E>nodo=checkPosition(p); 
	   E aux=nodo.element();
	   nodo.getPrev().setNext(nodo.getNext());
	   nodo.getNext().setPrev(nodo.getPrev());;
	   nodo.setNext(null);
	   nodo.setPrev(null);
	   size--;
	   return aux;}


public Iterator<E> iterator(){
	try{
	return new ElementIterator(this);
	   }
	catch(EmptyListException e){e.printStackTrace();}
	return null;}



public Iterable<Position<E>> positions(){
	         PositionList<Position<E>>l=new DoubleLinkedList<Position<E>>();
	         try{
	        	 if(!isEmpty()){
	        	 Position<E>p=first();
	        	
	        	 
	        	 while(p!=last()){
	        		 l.addLast(p);
	        		 p=next(p);
	        	                 }
	        	 l.addLast(p);
	        	               }
	        	 }
	         catch(EmptyListException e1){System.out.println(e1.getMessage());}
	         catch(BoundaryViolationException e2){System.out.println(e2.getMessage());}
	         catch(InvalidPositionException e3){System.out.println(e3.getMessage());}
return l;}




/**
 * Chequea el la posicion pasada por parámetros no sea nula y si lo es lanza un excepción.
 * @param p posicion a chequear.
 * @return retorna el nodo correspondiente a dicha posicion.
 * @throws InvalidPositionException excepción lanzada si la posicion pasada por parametros es nula.
 */


private Nodo<E> checkPosition(Position<E>p)throws InvalidPositionException{
	   if(p==null)
		   throw new InvalidPositionException("Posicion nula");
	   return (Nodo<E>)p;}


//////////////////////////////////////////////////////////////////////////////
public void Invertir(DoubleLinkedList<E>l){
	
    try{
    	invertirAux(l,l.first());
       }
    catch(EmptyListException e1){}
}

private void invertirAux(DoubleLinkedList<E>l,Position<E>p){
	
	try{    
	   
	    if(p!=l.last())
	      {
	       invertirAux(l,l.next(p));
	       l.addLast(p.element());
	       l.remove(p);}
	    else{
	    	 l.addFirst(p.element());
	         l.remove(p); 
	        }
	   }
	catch(EmptyListException e1){}
	catch(BoundaryViolationException e2){}
	catch(InvalidPositionException e3){}
	
}


}
