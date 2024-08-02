package Arbol;


	
	import TDAArbol.InvalidOperationException;
	import TDAArbol.EmptyTreeException;
	import TDALista.*;
	import java.util.Iterator;

	public class Arbol<E> implements Tree<E>{

		protected TNodo<E>root;
		protected int size;
		
		
		public Arbol(){
			size=0;
			root=null;}
		
		/**
		 * Consulta la cantidad de nodos en el árbol.
		 * @return Cantidad de nodos en el árbol.
		 */
		public int size(){return size;}
		
		/**
		 * Consulta si el árbol está vacío.
		 * @return Verdadero si el árbol está vacío, falso en caso contrario.
		 */
		public boolean isEmpty(){return size==0;}
		
		/**
		 * Devuelve un iterador de los elementos almacenados en el árbol en preorden.
		 * @return Iterador de los elementos almacenados en el árbol.
		 */
		public Iterator<E> iterator(){
			PositionList<E>l=new DoubleLinkedList<E>();
			for(Position<E>pos: positions())
				l.addLast(pos.element());
			try{
			return new ElementIterator<E>(l);
			   }
			catch(EmptyListException e){e.printStackTrace();}
			return null;
		}
		
		/**
		 * Devuelve una colección iterable de las posiciones de los nodos del árbol.
		 * @return Colección iterable de las posiciones de los nodos del árbol.
		 */
		public Iterable<Position<E>> positions(){
			PositionList<Position<E>>l=new DoubleLinkedList<Position<E>>();
			if(!isEmpty())
			pre(root,l);
			return l;
		}
		
		private void pre(TNodo<E>n,PositionList<Position<E>>l){
	         l.addLast(n);
	         
	         for(TNodo<E>pos: n.getChildren()){
	        	 pre(pos,l);
	         }                                                }
		
		
		/**
		 * Reemplaza el elemento almacenado en la posición dada por el elemento pasado por parámetro. Devuelve el elemento reemplazado.
		 * @param v Posición de un nodo.
		 * @param e Elemento a reemplazar en la posición pasada por parámetro.
		 * @return Elemento reemplazado.
		 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
		 */
		public E replace(Position<E> v, E e) throws InvalidPositionException{
			TNodo<E>nodo=checkPosition(v);
			E aux=nodo.element();
			nodo.setElement(e);
			return aux;
		}
		
		/**
		 * Devuelve la posición de la raíz del árbol.
		 * @return Posición de la raíz del árbol.
		 * @throws EmptyTreeException si el árbol está vacío.
		 */
		
			            
			         
		public Position<E> root() throws EmptyTreeException{
			if (root==null)
				throw new EmptyTreeException("no se puede pedir la raiz de un arbol vacio");
			return root;
		}
		
		/**
		 * Devuelve la posición del nodo padre del nodo correspondiente a una posición dada.
		 * @param v Posición de un nodo.
		 * @return Posición del nodo padre del nodo correspondiente a la posición dada.
		 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
		 * @throws BoundaryViolationException si la posición pasada por parámetro corresponde a la raíz del árbol.
		 */
		public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException{
			TNodo<E>nodo=checkPosition(v);
			if (nodo==root)
				throw new BoundaryViolationException("no puedo pedir padre a la raiz");
			return nodo.getParent();
		}
		
		/**
		 * Devuelve una colección iterable de los hijos del nodo correspondiente a una posición dada.
		 * @param v Posición de un nodo.
		 * @return Colección iterable de los hijos del nodo correspondiente a la posición pasada por parámetro.
		 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
		 */
		public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException{
			   TNodo<E>nodo=checkPosition(v);
			   PositionList<Position<E>>list=new DoubleLinkedList<Position<E>>();
			   for(Position<E>p: nodo.getChildren())
				   list.addLast(p);
			   return list;
			                                                                                 }
		
		/**
		 * Consulta si una posición corresponde a un nodo interno.
		 * @param v Posición de un nodo.
		 * @return Verdadero si la posición pasada por parámetro corresponde a un nodo interno, falso en caso contrario.
		 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
		 */
		public boolean isInternal(Position<E> v) throws InvalidPositionException{
			TNodo<E>nodo=checkPosition(v);
			return nodo.getChildren().size()!=0;}
		
		/**
		 * Consulta si una posición dada corresponde a un nodo externo.
		 * @param v Posición de un nodo.
		 * @return Verdadero si la posición pasada por parámetro corresponde a un nodo externo, falso en caso contrario.
		 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
		 */
		public boolean isExternal(Position<E> v) throws InvalidPositionException{
			 TNodo<E>nodo=checkPosition(v);
			 return nodo.getChildren().size()==0;}
		
		/**
		 * Consulta si una posición dada corresponde a la raíz del árbol.
		 * @param v Posición de un nodo.
		 * @return Verdadero, si la posición pasada por parámetro corresponde a la raíz del árbol,falso en caso contrario.
		 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
		 */
		public boolean isRoot(Position<E> v) throws InvalidPositionException{
			TNodo<E>nodo=checkPosition(v);
			return nodo==root;
		}
		
		/**
		 * Crea un nodo con rótulo e como raíz del árbol.
		 * @param E Rótulo que se asignará a la raíz del árbol.
		 * @throws InvalidOperationException si el árbol ya tiene un nodo raíz.
		 */
		public void createRoot(E e) throws InvalidOperationException{
			if (root!=null)
				throw new InvalidOperationException("no puede crear una raiz si el arbol ya tiene una");
			root=new TNodo<E>(e,null); size++;
		                                                              }
		
		/**
		 * Agrega un nodo con rótulo e como primer hijo de un nodo dado.
		 * @param e Rótulo del nuevo nodo.
		 * @param padre Posición del nodo padre.
		 * @return La posición del nuevo nodo creado.
		 * @throws InvalidPositionException si la posición pasada por parámetro es inválida o el árbol está vacío.
		 */
		public Position<E> addFirstChild(Position<E> p, E e) throws	InvalidPositionException{
			 
			 TNodo<E>nodo=checkPosition(p);
			 TNodo<E>nuevo=new TNodo<E>(e,nodo);
			 nodo.getChildren().addFirst(nuevo); 
			 size++;
			 return nuevo;
		}
		
		/**
		 * Agrega un nodo con rótulo e como útimo hijo de un nodo dado.
		 * @param e Rótulo del nuevo nodo.
		 * @param p Posición del nodo padre.
		 * @return La posición del nuevo nodo creado.
		 * @throws InvalidPositionException si la posición pasada por parámetro es inválida o el árbol está vacío.
		 */
		public Position<E> addLastChild(Position<E> p, E e) throws InvalidPositionException{
			
			 TNodo<E>nodo=checkPosition(p);
			 TNodo<E>nuevo=new TNodo<E>(e,nodo);
			 nodo.getChildren().addLast(nuevo);
			 size++;
			return nuevo;}
		
		/**
		 * Agrega un nodo con rótulo e como hijo de un nodo padre dado. El nuevo nodo se agregará delante de otro nodo también dado.
		 * @param e Rótulo del nuevo nodo.
		 * @param p Posición del nodo padre.
		 * @param rb Posición del nodo que será el hermano derecho del nuevo nodo.
		 * @return La posición del nuevo nodo creado.
		 * @throws InvalidPositionException si la posición pasada por parámetro es inválida, o el árbol está vacío, o la posición rb no corresponde a un nodo hijo del nodo referenciado por p.
		 */
		public Position<E> addBefore(Position<E> p, Position<E> rb, E e) throws InvalidPositionException{
			       
			    
			       TNodo<E>padre=checkPosition(p);
			       TNodo<E>hermano=checkPosition(rb);
			       if(hermano.getParent()!=p)
			    	   throw new InvalidPositionException("la posicion RB no es hijo de la posicion P");
			       TNodo<E>nuevo=new TNodo<E>(e,padre);
			       PositionList<TNodo<E>>hijos=padre.getChildren();
			       try{
			    	   boolean esta=false;
			    	  
			    	   Position<TNodo<E>>pos=hijos.first();
			    	   while(!esta&&pos!=null){
			    		   if(pos.element()==hermano)
			    			  esta=true;
			    		   else if(pos==hijos.last())
                  		          pos=null;
			    		   else pos=hijos.next(pos);
			    	               }
			    	 
			    	   hijos.addBefore(pos,nuevo);size++;
			           }
			       catch(EmptyListException e1){System.out.println(e1.getMessage());}
			       catch(BoundaryViolationException e2){System.out.println(e2.getMessage());}

		            return nuevo;}
		
		/**
		 * Agrega un nodo con rótulo e como hijo de un nodo padre dado. El nuevo nodo se agregará a continuación de otro nodo también dado.
		 * @param e Rótulo del nuevo nodo.
		 * @param p Posición del nodo padre.
		 * @param lb Posición del nodo que será el hermano izquierdo del nuevo nodo.
		 * @return La posición del nuevo nodo creado.
		 * @throws InvalidPositionException si la posición pasada por parámetro es inválida, o el árbol está vacío, o la posición lb no corresponde a un nodo hijo del nodo referenciado por p.
		 */
		public Position<E> addAfter (Position<E> p, Position<E> lb, E e) throws InvalidPositionException{
			        
			         TNodo<E>padre=checkPosition(p);
			         TNodo<E>hermano=checkPosition(lb);
			         if(hermano.getParent()!=padre)
			        	 throw new InvalidPositionException("la posicion LB no es hijo de la posicion P");
			         TNodo<E>nuevo=new TNodo<E>(e,padre);
			         PositionList<TNodo<E>>hijos=padre.getChildren();
			         try{
			        	 boolean esta=false; 
			        	 Position<TNodo<E>>pos=hijos.first();
			        	 while(!esta&&pos!=null){
			        		 if (pos.element()!=hermano)
			        			   if(pos!=hijos.last())
			        				   pos=hijos.next(pos);
			        			   else pos=null;
			        		 else {esta=true;
			                    hijos.addAfter(pos, nuevo);
			                    size++;
			        		  }
			        		 }
			        	if(pos!=null&&!esta) 
			             throw new InvalidPositionException("la posicion pasada es invalida");
			        		
			         }
			         catch(EmptyListException e1){System.out.println(e1.getMessage());}
			         catch(BoundaryViolationException e2){System.out.println(e2.getMessage());}
			         
		  return nuevo;} 
		
	    
		
		/**
		 * Elimina el nodo referenciado por una posición dada, si se trata de un nodo externo. 
		 * @param n Posición del nodo a eliminar.
		 * @throws InvalidPositionException si la posición pasada por parámetro es inválida o no corresponde a un nodo externo, o el árbol está vacío.
		 */
		public void removeExternalNode (Position<E> p) throws InvalidPositionException{
			 if(isInternal(p))
				 throw new InvalidPositionException("la posicion a remover corresponde a un nodo interno removeExternal");
			  TNodo<E>nodo=checkPosition(p);
			 
			  if(nodo==root)
				  {root=null;size--;}
			  else{TNodo<E>padre=nodo.getParent();
			       PositionList<TNodo<E>>hijos=padre.getChildren();
			       try{
			    	   Position<TNodo<E>>pos=hijos.first();
			    	   boolean esta=false;
			    	   while(!esta&&pos!=null){
			    		 
			    		   if(pos.element()==nodo)
			    			   esta=true;
			    		   else if(pos==hijos.last())
              		               pos=null; 
			    		         else pos=hijos.next(pos);}
			      
			    	 nodo.setParent(null);
			         hijos.remove(pos);
			         size--;
			           }
			       catch(EmptyListException e1){System.out.println(e1.getMessage());}
			       catch(BoundaryViolationException e2){System.out.println(e2.getMessage());}
			              }
				  
	                                                                                   	}
                      		
		
		
		
		/**
		 * Elimina el nodo referenciado por una posición dada, si se trata de un nodo interno. Los hijos del nodo eliminado lo reemplazan en el mismo orden en el que aparecen. 
		 * Si el nodo a eliminar es la raíz del árbol,  únicamente podrá ser eliminado si tiene un solo hijo, el cual lo reemplazará.
		 * @param n Posición del nodo a eliminar.
		 * @throws InvalidPositionException si la posición pasada por parámetro es inválida o no corresponde a un nodo interno o corresponde a la raíz (con más de un hijo), o el árbol está vacío.
		 */
		public void removeInternalNode (Position<E> p) throws InvalidPositionException{
		     
			
			   if(!isInternal(p))
		        	throw new InvalidPositionException("no puede usarse el remove internal en una posicion externa");
		        TNodo<E>nodo=checkPosition(p);
		        try{
		            if(nodo==root&&nodo.getChildren().size()==1)
		               {root=nodo.getChildren().first().element();
		               size--;
		               root.setParent(null);}
		            else if(nodo==root)
		            	 throw new InvalidPositionException("No puedo eliminar la raiz si tiene más de un hijo");
		                 else{ TNodo<E>padre=nodo.getParent();
		                       PositionList<TNodo<E>>hermanos=padre.getChildren();
		                       PositionList<TNodo<E>>hijos=nodo.getChildren();
		                       boolean esta=false;
		                       Position<TNodo<E>>pos=hermanos.first();
		                       while(!esta&&pos!=null){
		                    	   if(pos.element()==nodo)
		                    		   esta=true;
		                    	   else if(pos==hermanos.last())
		                    		     pos=null;
		                    	         else pos=hermanos.next(pos);
		                                    }
		                    for(TNodo<E>posHijo: hijos){
		                    	  hermanos.addBefore(pos, posHijo);
		                    	  posHijo.setParent(padre);
		                                                                    }
		                    nodo.setParent(null);
		                    hermanos.remove(pos);
		                    size--;
		                       
		                      }
		           
		        
		            }
		        catch(EmptyListException e1){System.out.println(e1.getMessage());}
		        catch(BoundaryViolationException e2){System.out.println(e2.getMessage());}
		        
		        }
		
		/**
		 * Elimina el nodo referenciado por una posición dada. Si se trata de un nodo interno. Los hijos del nodo eliminado lo reemplazan en el mismo orden en el que aparecen. 
		 * Si el nodo a eliminar es la raíz del árbol,  únicamente podrá ser eliminado si tiene un solo hijo, el cual lo reemplazará.
		 * @param n Posición del nodo a eliminar.
		 * @throws InvalidPositionException si la posición pasada por parámetro es inválida o corresponde a la raíz (con más de un hijo), o el árbol está vacío.
		 */
		public void removeNode (Position<E> p) throws InvalidPositionException{
			 if(isInternal(p))
				 removeInternalNode(p);
			 else 
				  removeExternalNode(p);
		}
		
		
		private TNodo<E> checkPosition(Position<E>p)throws InvalidPositionException{
			 if(p==null)
		            throw new InvalidPositionException("Posicion invalida");
		        if(isEmpty())
		            throw new InvalidPositionException("El arbol est� vacio");
			return (TNodo<E>)p;}
		
		

	
/*-------------------------------------------------------------------------------------*/
	public Tree<E> espejo(Tree<E>t1){
		Tree<E>t2=new Arbol<E>();
       try{if(!t1.isEmpty())
    	   {t2.createRoot(t1.root().element());
    	    espejoAux(t1,t2,t1.root(),t2.root());
    	                             }
           }
       catch(InvalidOperationException e1){}
       catch(EmptyTreeException e2){}
		
		return t2;}
	
	
public void espejoAux(Tree<E>t1,Tree<E>t2,Position<E>p1,Position<E>p2){
	  try{
		     for(Position<E>pos1: t1.children(p1)){
             t2.addFirstChild(p2, pos1.element());
		     for(Position<E>pos2: t2.children(p2))
		    	 espejoAux(t1,t2,pos1,pos2);}
		  }
	  
       catch(InvalidPositionException e1){}                                                 }	
	
	}
