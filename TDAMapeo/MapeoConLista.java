package TDAMapeo;

import TDALista.*;
import TDAPriorityQueue.Entry;
import TDAPriorityQueue.Entrada;
import TDAPriorityQueue.InvalidKeyException;

public class MapeoConLista<K,V> implements Map<K,V> {
	
private PositionList<Entrada<K,V>>list;
	
public MapeoConLista(){
	  list=new DoubleLinkedList<Entrada<K,V>>();
                      }

public int size(){return list.size();}



public boolean isEmpty(){return list.isEmpty();}


public V remove(K k)throws InvalidKeyException{
	   checkKey(k);
	   for(Position<Entrada<K,V>>pos: list.positions())
		   if(pos.element().getKey().equals(k))
		   {V v=pos.element().getValue();
		   try{
		   list.remove(pos);}
		   catch(InvalidPositionException e1){System.out.println(e1.getMessage());}
		   return v;}
	  
	   
return null;}


public V put(K k, V v)throws InvalidKeyException{
            checkKey(k);
            for(Position<Entrada<K,V>>pos: list.positions())
            	 if(pos.element().getKey().equals(k))
            	  { V aux=pos.element().getValue();
            	  pos.element().setValue(v);
            	  return aux;}
            list.addLast(new Entrada<K,V>(k,v));
            return null;}


public V get(K k)throws InvalidKeyException{
           checkKey(k);
           for(Position<Entrada<K,V>>pos: list.positions())
        	   if(pos.element().getKey().equals(k))
        	    return pos.element().getValue();
          
return null;}




public Iterable<V> values(){
	  PositionList<V>l=new DoubleLinkedList<V>();
	  for(Position<Entrada<K,V>>pos: list.positions())
		  l.addLast(pos.element().getValue());
	  return l;}

public Iterable<K> keys(){
	 PositionList<K>l=new DoubleLinkedList<K>();
	 for(Position<Entrada<K,V>>pos: list.positions())
		 l.addLast(pos.element().getKey());
	  return l;}

public Iterable<Entry<K,V>> entries(){
	PositionList<Entry<K,V>>l=new DoubleLinkedList<Entry<K,V>>();
	for(Position<Entrada<K,V>>pos: list.positions())
		l.addLast(pos.element());
	return l;}

private void checkKey(K k)throws InvalidKeyException{
	 if(k==null)
		 throw new InvalidKeyException("la clave es invalida");}



}


