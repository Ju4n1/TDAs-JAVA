package Arbol;
import TDALista.*;
public class TNodo<E> implements Position<E> {
	
protected TNodo<E> parent;
protected E rotulo;
protected PositionList<TNodo<E>>children;

public TNodo(E item, TNodo<E>p){
	parent=p; rotulo=item;
	children=new DoubleLinkedList<TNodo<E>>();}

public E element(){return rotulo;}
	
public PositionList<TNodo<E>> getChildren(){return children;}

public TNodo<E> getParent(){return parent;}

public void setElement(E item){rotulo=item;}

public void setParent(TNodo<E>p){parent=p;}

}
