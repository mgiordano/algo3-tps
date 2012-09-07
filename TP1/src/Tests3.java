package src;

public class Tests3 {

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.problemas.Ej3;
import src.problemas.Liston;
import src.problemas.Solucion;
import src.problemas.aux;

public class Tests3 {
	
	@Test
	public void testSolucion(){
		
		//Test Constructor Vacio
		Solucion sol = new Solucion();
		Integer[] a = new Integer[sol.cortes.size()];
		assertEquals(0, sol.costo);
		assertArrayEquals(new Integer[] {}, sol.cortes.toArray(a));
		
		//Test Constructor con valores
		Solucion sol1 = new Solucion(20,5);
		Integer[] b = new Integer[sol1.cortes.size()];
		assertEquals(20, sol1.costo);
		assertArrayEquals(new Integer[] {5}, sol1.cortes.toArray(b));
		
		//Test funcion combinar
		Solucion sol2 = new Solucion(50, 3);
		Solucion solComb = Solucion.combinar(sol1,sol2,70,1);
		
		Integer[] c = new Integer[solComb.cortes.size()];
		
		assertEquals(70, solComb.costo);
		assertArrayEquals(new Integer[] {1,5,3}, solComb.cortes.toArray(c));
	}
	
	@Test
	public void testListon(){
		
		//Test Constructor y Metodos
		int[] a = new int[] {1,2,3,4};
		Liston liston = new Liston(10, a);
		assertEquals(10, liston.largo);
		assertArrayEquals(a, liston.cortes);
		
		assertEquals(4, liston.cantCortes());
		assertEquals(1, liston.dameCorte(0));
		assertEquals(4, liston.dameCorte(3));
		
		for (int i = 0; i < liston.cantCortes()-1; i++){
			for (int j = i; j < liston.cantCortes()-1; j++){
				assertEquals(false, liston.haySolucion(i,j));
			}
		}
		
		Solucion sol1 = new Solucion(10, 2);
		Solucion sol2 = new Solucion(25, 6);
		Solucion sol3 = Solucion.combinar(sol1,sol2,40,3);
		
		liston.insertarSolucion(0, 0, sol1);
		liston.insertarSolucion(0, 3, sol2);
		liston.insertarSolucion(3, 3, sol3);
		
		assertEquals(true, liston.haySolucion(0, 0));
		assertEquals(sol1, liston.dameSolucion(0,0));
		assertEquals(true, liston.haySolucion(0, 3));
		assertEquals(sol2, liston.dameSolucion(0, 3));
		assertEquals(true, liston.haySolucion(3, 3));
		assertEquals(sol3, liston.dameSolucion(3, 3));
	
	}
	
	@Test
	public void cortesChico(){
		
		Liston liston1 = new Liston(10, new int[] {2,4,7});
		Solucion solucion1 = Ej3.cortarListon(liston1);
		assertEquals( 20 , solucion1.costo);
		Integer[] a = new Integer[solucion1.cortes.size()];
		assertArrayEquals(new Integer[] {4,2,7}, solucion1.cortes.toArray(a));
		
		Liston liston2 = new Liston(10, new int[] {4,5,7,8});
		Solucion solucion2 = Ej3.cortarListon(liston2);
		assertEquals( 22 , solucion2.costo);
		Integer[] b = new Integer[solucion2.cortes.size()];
		assertArrayEquals(new Integer[] {4,7,5,8}, solucion2.cortes.toArray(b));
		
		Liston liston3 = new Liston(100, new int[] {25,50,75});
		Solucion solucion3 = Ej3.cortarListon(liston3);
		assertEquals( 200 , solucion3.costo);
		Integer[] c = new Integer[solucion3.cortes.size()];
		assertArrayEquals(new Integer[] {50,25,75}, solucion3.cortes.toArray(c));
		
		Liston liston4 = new Liston(20, new int[] {5,7,15});
		Solucion solucion4 = Ej3.cortarListon(liston4);
		assertEquals( 40 , solucion4.costo);
		Integer[] d = new Integer[solucion4.cortes.size()];
		assertArrayEquals(new Integer[] {7,5,15}, solucion4.cortes.toArray(d));
		
	}
	
	@Test
	public void cortesMediano(){
		
		Liston liston1 = new Liston(200, new int[] {5,7,15,45,70,99,119,150,166,190});
		Solucion solucion1 = Ej3.cortarListon(liston1);
		assertEquals(656 , solucion1.costo);
		Integer[] a = new Integer[solucion1.cortes.size()];
		assertArrayEquals(new Integer[] {99,45,15,7,5,70,150,119,166,190}, solucion1.cortes.toArray(a));
	
		aux.imprimirLista(solucion1.cortes);
	}
	
	@Test
	public void cortesGrande(){
		
		Liston liston1 = new Liston(1200, new int[] {5,7,10,15,20,26,30,37,41,45,52,55,59,60,70,74,79,89,99,106,119,150,166,190,204,217,228,245,267,299,301,314,320,330,340,350,360,376,388,397,405,411,436,440,450,460,477,481,490,500,545,587,600,611,634,655,675,685,690,699,700,720,743,756,777,785,793,799,804,812,819,825,830,840,861,870,888,899,923,945,978,1023,1050,1078,1099,1101,1110,1128,1167,1177,1182,1198});
		Solucion solucion1 = Ej3.cortarListon(liston1);
		//assertEquals(656 , solucion1.costo);
		//Integer[] a = new Integer[solucion1.cortes.size()];
		//assertArrayEquals(new Integer[] {99,45,15,7,5,70,150,119,166,190}, solucion1.cortes.toArray(a));
		aux.imprimirLista(solucion1.cortes);
	}
	
	@Test
	public void cortesFromFile(){
		
		Ej3.resolverFile("./tests/Tp1Ej3.in");
	}
}
