package TDAGrafo;


import TDALista.*;


public class GrafoListaAdy<V,E>implements Graph<V,E> {

	
public PositionList<Vertice<V,E>>nodos;


public GrafoListaAdy(){
	nodos=new DoubleLinkedList<Vertice<V,E>>();}

public Iterable<Vertex<V>> vertices(){
	PositionList<Vertex<V>>ver=new DoubleLinkedList<Vertex<V>>();
	for(Vertex<V>v:nodos)
		ver.addLast(v);
return ver;}



public Iterable<Edge<E>> edges(){
	PositionList<Edge<E>>ed=new DoubleLinkedList<Edge<E>>();
    for(Vertex<V>v:nodos)
    	for(Edge<E>e: succesorEdges(v))
    		ed.addLast(e);
return ed;}


public Iterable<Edge<E>> incidentEdges(Vertex<V>v)throws InvalidVertexException{
	 PositionList<Edge<E>>l=new DoubleLinkedList<Edge<E>>();
     Vertice<V,E>ver=checkVertex(v);
     for(Edge<E>e: ver.getAdyacentes())
	     l.addLast(e);
	 return l;}


public Edge<E> insertEdge(Vertex<V>v1,Vertex<V>v2,E e)throws InvalidVertexException{
	         Vertice<V,E>ver1=checkVertex(v1);
	         Vertice<V,E>ver2=checkVertex(v2);
	         Arco<V,E>arco= new Arco<V,E>(e,ver1,ver2);
             ver1.getAdyacentes().addLast(arco);
             ver2.getAdyacentes().addLast(arco);
            try{
             arco.setPosicionEnAdyacentes(ver1.getAdyacentes().last());
               }
            catch(EmptyListException e1){System.out.println(e1.getMessage());}
	     return arco;}


public V replace(Vertex<V>v,V x)throws InvalidVertexException{
	  Vertice<V,E>ver=checkVertex(v);
	 V salida=ver.element();
	 ver.setElement(x);
return salida;}


public Vertex<V> insertVertex(V v){
	    Vertice<V,E>salida=new Vertice<V,E>(v);
	    nodos.addLast(salida);
	    try{
	    salida.setPositionEnVertices(nodos.last());
	       }
	    catch(EmptyListException e){System.out.println(e.getMessage());}

return salida;}


public E removeEdge(Edge<E>e)throws InvalidEdgeException{
	        Arco<V,E>ar=checkEdge(e); E salida=ar.element();
	     try{ 
	        ar.getV1().getAdyacentes().remove(ar.getPosicionEnAdyacentes());
	        ar.getV2().getAdyacentes().remove(ar.getPosicionEnAdyacentes());
	         }
	     catch(InvalidPositionException e1){}
	        return salida;}


public V removeVertex(Vertex<V> v)throws InvalidVertexException {
     V salida=null;
	try {
       Position<Vertice<V,E>>pos=checkVertex(v).getPositionEnVertices();
	   salida=nodos.remove(pos).element();
         } 
	catch(InvalidPositionException e) {}

	return salida;}


public boolean areAdjacent(Vertex<V>v1, Vertex<V>v2)throws InvalidVertexException{
	   boolean salida=false;
	   Vertice<V,E>ver1=checkVertex(v1);
	   Vertice<V,E>ver2=checkVertex(v2);
	   for(Arco<V,E>e: ver1.getAdyacentes())
	       if((e.getV1()==ver1&&e.getV2()==ver2)||(e.getV2()==ver1&&e.getV1()==ver2))
	    	   salida=true;
return salida;}


public Vertex<V> opposite(Vertex<V>v,Edge<E>e)throws InvalidVertexException,InvalidEdgeException{
	        Arco<V,E>ar=checkEdge(e);
	        Vertice<V,E>ver=checkVertex(v);
	        Vertice<V,E>salida=null;
	        if(ver==ar.getV1())
	        	salida=ar.getV2();
	        else if(ver==ar.getV2())
	        	 salida=ar.getV1();
return salida;}


public Vertex<V>[] endvertices(Edge<E>e)throws InvalidEdgeException{
	Vertex<V> [] a = (Vertex<V> []) new Vertice[2];
	Arco<V,E>arco=checkEdge(e);
	a[0]=arco.getV1();
	a[1]=arco.getV2();

return a;}


/*------------------------------------------------------------------------------------------------------------------------------------------------------
 ---------------------------------------------------MÉTODOS--PRIVADOS-----------------------------------------------------------------------------------
 -------------------------------------------------------------------------------------------------------------------------------------------------------*/


private Iterable<Edge<E>> succesorEdges(Vertex<V>v){
	PositionList<Edge<E>>edges=new DoubleLinkedList<Edge<E>>();
   try{
	   Vertice<V,E>v1=checkVertex(v);
	   for(Edge<E>e: v1.getAdyacentes())
		   edges.addLast(e);
      }
   catch(InvalidVertexException e1){}
	
return edges;}


private Vertice<V,E> checkVertex(Vertex<V>v1)throws InvalidVertexException{
	if(v1==null)
		throw new InvalidVertexException("el vertice pasado por parámetros es nulo");
	try{
	    return (Vertice<V,E>)v1;
	    }
	catch(ClassCastException e){new InvalidVertexException("la posicion pasada por parametros no corresponde a un vertice");}  
	
return null;}


private Arco<V,E> checkEdge(Edge<E>ed)throws InvalidEdgeException{
	if(ed==null)
		throw new InvalidEdgeException("el arco pasado por parametros es nulo");
   try{
	   return (Arco<V,E>)ed;}
   catch(ClassCastException e1){new InvalidEdgeException("el atributo pasado por parametros no corresponde a un arco");}

return null;}

}
