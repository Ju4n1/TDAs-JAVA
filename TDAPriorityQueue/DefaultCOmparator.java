package TDAPriorityQueue;

public class DefaultCOmparator<K extends Comparable<K>> implements java.util.Comparator<K> {
	
	   public int compare( K a, K b ) {
	return a.compareTo( b );}

}	
	

