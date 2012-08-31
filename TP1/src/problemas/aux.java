package src.problemas;

import java.util.List;
import java.util.ListIterator;

public class aux {
	
	public static void imprimirLista(List<Integer> lista){
		
		ListIterator<Integer> it = lista.listIterator();
		while (it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println("");
	}
}
