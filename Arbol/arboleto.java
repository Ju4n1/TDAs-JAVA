package Arbol;
import TDALista.*;
import TDAArbol.InvalidOperationException;
import TDAArbol.EmptyTreeException;
public class arboleto {

public static void main(String[]args){
	
	
	

Arbol<String>T1=new Arbol<String>();
try{
T1.createRoot("raiz");
T1.addFirstChild(T1.root(), "2");
T1.addFirstChild(T1.root(), "1");
for(Position<String>p: T1.children(T1.root())){
	T1.addFirstChild(p, "4");
	T1.addFirstChild(p, "3");
}

Tree<String>T2=T1.espejo(T1);

for(Position<String>p: T2.positions()){
	 System.out.println(p.element());
}
}
catch(InvalidPositionException e1){}
catch(InvalidOperationException e2){}
catch(EmptyTreeException e3){}
	
}

}
