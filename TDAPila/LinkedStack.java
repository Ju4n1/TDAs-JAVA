package TDAPila;
/**
 * Clase LinkedStack implementa la interfaz Stack.
 * @author Juan Cruz Feuilles y Juan Pablo Ziegler.
 *
 * @param <E> parámetro genérico de la clase.
 */
public class LinkedStack<E>implements Stack<E> {
	
	protected int size; 
	
	protected Nodo<E> top;

/**
 *Crea una nueva pila enlazada vacia con tope nulo. 	
 */
	
public LinkedStack(){size=0; top=null;}	
	
public int size(){
	 return size;}	



public boolean isEmpty(){
	      return size==0;}



public void push(E item){
	     Nodo<E>n=new Nodo<E>(item);
	     n.setNext(top);top=n; 
	     size++;}



public E top()throws EmptyStackException{
	   if(isEmpty())
	      throw new EmptyStackException("La pila esta vacia......Pila.top()");
	  return top.element();}



public E pop()throws EmptyStackException{
	if(isEmpty())
		throw new EmptyStackException("La pila esta vacia.....Pila.pop()");
	E aux=top.element();
	top=top.getNext();
	size--;
    return aux;}

}