package TDADiccionario;
import TDALista.*;
import TDAPriorityQueue.Entry;
import TDAPriorityQueue.Entrada;
import java.util.Iterator;
public class DiccionarioConHash<K,V> implements Dictionary<K,V> {
	
protected int size;
protected PositionList<Entry<K,V>>[]buckets;


public DiccionarioConHash(int cant){
	buckets=(PositionList<Entry<K,V>>[])new DoubleLinkedList[cant];
	
	for(int i=0;i<buckets.length;i++)
	  buckets[i]=new DoubleLinkedList<Entry<K,V>>();
	
	 size=0;}

public DiccionarioConHash(){
	this(27);}

public int size(){return size;}

public boolean isEmpty(){return size==0;}

public Entry<K,V> insertar(K k, V v){
	 
	 Entry<K,V>en=new Entrada<K,V>(k,v);
     int code=Math.abs(k.hashCode())%buckets.length;

     Iterator<Entry<K,V>>it=buckets[code].iterator();
     Entry<K,V>entrada;
     boolean esta=false;
       while(it.hasNext()&&!esta){
    	    entrada=it.next();
    	    if((entrada.getKey()==en.getKey())&&(entrada.getValue()==en.getValue()))
    	       {esta=true;}
    	     else {buckets[code].addLast(en); 
    	          esta=true; 
    	          size++;}	    
                              }
return en;}

public Iterable<Entry<K,V>> entris(){
	PositionList<Entry<K,V>>list=new DoubleLinkedList<Entry<K,V>>();
	for(int i=0;i<buckets.length;i++){
		for(Entry<K,V>en: buckets[i]){
			list.addLast(en);}
	                                 }
return list;}

public Entry<K,V> find(K k){
	Entry<K,V>salida=null;
	int code=Math.abs(k.hashCode())%buckets.length;
    boolean esta=false;
	Iterator<Entry<K,V>>it=buckets[code].iterator();
	Entry<K,V>ent=null;
	while(it.hasNext()&&!esta){
		 ent=it.next();
	  if (ent.getKey().equals(k))
		  esta=true;}
   
	if(esta)
	 salida=ent;	
	
return salida;}

public Iterable<Entry<K,V>> findAll(K k){
 PositionList<Entry<K,V>>list=new DoubleLinkedList<Entry<K,V>>();
 int code=Math.abs(k.hashCode())%buckets.length;
    for(Entry<K,V>en: buckets[code])
    	if(en.getKey().equals(k))
    		list.addLast(en);
return list;}

public Entry<K,V> remove(Entry<K,V>e){
 	
 int conde=Math.abs(e.getKey().hashCode())%buckets.length;
	
 }

}