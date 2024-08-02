package TDAGrafo;

import TDALista.*;

public class Vertice<V,E> implements Vertex<V> {
	
private V rotulo;

private PositionList<Arco<V,E>> adyacentes;

private Position<Vertice<V,E>> posicionEnVertices;
	
public Vertice(V rot){
	rotulo=rot;
	adyacentes=new DoubleLinkedList<Arco<V,E>>();}

public V element(){
	return rotulo;}	

public Position<Vertice<V,E>> getPositionEnVertices(){return posicionEnVertices;}

public PositionList<Arco<V,E>> getAdyacentes(){return adyacentes;}

public void setPositionEnVertices(Position<Vertice<V,E>> p){posicionEnVertices=p;}

public void setElement(V v){rotulo=v;}

}
