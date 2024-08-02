package TDAPriorityQueue;

public class Entrada<K,V>  implements Entry<K,V>{

private K key;
private V value;

public Entrada(K k, V v){
	value=v;
	key=k;}

public K getKey(){return key;}

public V getValue(){return value;}

public void setKey(K k){key=k;}

public void setValue(V v){value=v;}
	

}
