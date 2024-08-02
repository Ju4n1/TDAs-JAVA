package TDAMapeo;

import TDAPriorityQueue.Entry;
import TDAPriorityQueue.InvalidKeyException;

public interface Map<K,V> {
	
public int size();

public boolean isEmpty();

public V get(K k)throws InvalidKeyException;

public V put(K k, V v)throws InvalidKeyException;

public V remove(K k)throws InvalidKeyException;

public Iterable<K> keys();

public Iterable<V> values();

public Iterable<Entry<K,V>> entries();







}
