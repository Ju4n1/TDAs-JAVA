package TDAGrafo;
import TDALista.Position;
public class Arco<V,E> implements Edge<E> {
	
private E rotulo;
private Vertice<V,E>v1,v2;
private Position<Arco<V,E>>posicionEnAdyacentes;
private Position<Arco<V,E>> posicionEnadyacentess;



public Arco(E rotulo, Vertice<V,E>v1, Vertice<V,E>v2){ 
	 this.rotulo=rotulo;
	 this.v1=v1;
	 this.v2=v2;}



public E element(){
	return rotulo;}

public Vertice<V,E> getV1(){
	return v1;}

public Vertice<V,E>getV2(){
	return v2;}

public Position<Arco<V,E>> getPosicionEnAdyacentes(){
	return posicionEnAdyacentes;}

public void setElement(E e){
	rotulo=e;}

public void setV1(Vertice<V,E> v){
	v1=v;}

public void setV2(Vertice<V,E> v){
	v2=v;}

public void setPosicionEnAdyacentes(Position<Arco<V,E>>p){
	     posicionEnAdyacentes=p;}

}
