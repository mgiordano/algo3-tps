package src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.problemas.Ej3;
import src.problemas.Liston;
import src.problemas.Solucion;
import src.problemas.aux;

/*import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;*/

public class Tests3 {
	
	@Test
	public void test3(){
		
		Liston liston1 = new Liston(10, new int[] {2,4,7});
		Solucion solucion1 = Ej3.cortarListon(liston1);
		assertEquals( 20 , solucion1.costo);
		
		aux.imprimirLista(solucion1.cortes);
		
		Liston liston2 = new Liston(10, new int[] {4,5,7,8});
		Solucion solucion2 = Ej3.cortarListon(liston2);
		assertEquals( 22 , solucion2.costo);
		
		aux.imprimirLista(solucion2.cortes);
		
		Liston liston3 = new Liston(100, new int[] {25,50,75});
		Solucion solucion3 = Ej3.cortarListon(liston3);
		assertEquals( 200 , solucion3.costo);
		
		aux.imprimirLista(solucion3.cortes);
	}

}
