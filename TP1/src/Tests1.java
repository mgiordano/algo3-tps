package src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import src.problemas.Ej1;

public class Tests1 {
	
	//tests chicos que muestran el correcto funcionamiento del algoritmo y las funciones para levantar desde archivos
	@Test
	public void leerListaString(){
		
		assertArrayEquals( new int[] { 40,58,32,155,1096,2,0,0,1,4 } , Ej1.leer("40 58 32 155 1096 2 0 0 1 4") );
		assertArrayEquals( new int[] { 1,0,2,5,69,12,0,18 } , Ej1.leer("1 0 2 5 69 12 0 18") );
		assertArrayEquals( new int[] { 198227,12123,1241234,19,1,212 } , Ej1.leer("198227 12123 1241234 019 1 212") );
		assertArrayEquals( new int[] { 19,7,123,12,19,1,22 } , Ej1.leer("19    7       123 12    00019 1    22") );
	}
	
	@Test
	public void preciosDecrecientes(){
		
		assertEquals( 0, Ej1.buscarGanancia( new int[] { 4,3,2,1 } ) );
		assertEquals( 0, Ej1.buscarGanancia( new int[] { 10,9,8,7,6,5,4,3,2,1 } ) );
		assertEquals( 0, Ej1.buscarGanancia( new int[] { 0,0,0,0,0,0 } ) );	
	}
	
	@Test
	public void preciosCrecientes(){
		
		assertEquals( 8, Ej1.buscarGanancia( new int[] { 1,2,5,7,9 } ) );
		assertEquals( 30, Ej1.buscarGanancia( new int[] { 10,15,20,25,30,35,40 } ) );
		assertEquals( 45, Ej1.buscarGanancia( new int[] { 25,30,35,35,40,45,70 } ) );
	}
	
	@Test
	public void preciosPicos(){
		
		assertEquals( 38, Ej1.buscarGanancia( new int[] { 12,14,50,2,11,14,1 } ) );
		assertEquals( 253, Ej1.buscarGanancia( new int[] { 22,78,3,59,200,256,2 } ) );
		assertEquals( 995, Ej1.buscarGanancia( new int[] { 101,65,20,5,80,530,10,1000 } ) );

	}
	
	@Test
	public void preciosFromString(){
		assertEquals( 10, Ej1.buscarGanancia( Ej1.leer("3 9 8 13 1 1 0") ) );
		assertEquals( 5, Ej1.buscarGanancia( Ej1.leer("97 14 2 5 7 2 2") ) );
		assertEquals( 492, Ej1.buscarGanancia( Ej1.leer("8 20 150 500 9 35 12") ) );

	}
	
	@Test
	public void casosPatologicos(){
		//caso decreciente
		assertEquals(0, Ej1.buscarGanancia( new int[] { 30,29,26,25,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,2,1 } ) );
		assertEquals(0, Ej1.buscarGanancia( new int[] { 30,29,28,27,26,25,24,23,22,21,9,8,7,6,5,4,3,2,1 } ) );
		assertEquals(0, Ej1.buscarGanancia( new int[] { 30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1 } ) );
		//caso creciente
		assertEquals(11, Ej1.buscarGanancia( new int[] { 1,2,3,4,5,6,7,8,9,10,11,12}) );
		assertEquals(21, Ej1.buscarGanancia( new int[] { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22}) );
		assertEquals(29, Ej1.buscarGanancia( new int[] { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30}) );
		//caso aleatorio
		assertEquals(28, Ej1.buscarGanancia( new int[] { 1,5,2,3,10,7,6,9,11,14,15,13,12,16,20,24,22,23,21,29,28}) );
		assertEquals(27, Ej1.buscarGanancia( new int[] { 2,4,3,10,8,7,6,9,11,14,15,13,12,16,20,17,19,27,26,29,28}) );
		assertEquals(28, Ej1.buscarGanancia( new int[] { 5,2,3,10,8,7,6,9,11,14,15,13,12,16,20,17,19,18,24,22,23,21,25,30,27,26,29,28}) );
	}
	
	@Test
	public void testsDeStress(){
			//crecientes
			Ej1.resolverFile("./tests/testsAvanzados/Ej1/testsCrecientes/test30000.in");
			Ej1.resolverFile("./tests/testsAvanzados/Ej1/testsCrecientes/test35000.in");
			Ej1.resolverFile("./tests/testsAvanzados/Ej1/testsCrecientes/test40000.in");
			//decrecientes
			Ej1.resolverFile("./tests/testsAvanzados/Ej1/testsDecrecientes/test30000.in");
			Ej1.resolverFile("./tests/testsAvanzados/Ej1/testsDecrecientes/test35000.in");
			Ej1.resolverFile("./tests/testsAvanzados/Ej1/testsDecrecientes/test40000.in");
			//random
			Ej1.resolverFile("./tests/testsAvanzados/Ej1/testsRandom/test30000.in");
			Ej1.resolverFile("./tests/testsAvanzados/Ej1/testsRandom/test35000.in");
			Ej1.resolverFile("./tests/testsAvanzados/Ej1/testsRandom/test40000.in");
	}
	
	//test para correr desde un archivo
	@Test
	public void preciosFromFile(){
			Ej1.resolverFile("./tests/testsAvanzados/Ej1/testsRandom/test15000.in");
	}
	


}
