package src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import src.problemas.Ej1;

public class Tests1 {
	
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
	public void preciosFromFile(){

		Ej1.resolver("./tests/Tp1Ej1.in");
		
	}

}
