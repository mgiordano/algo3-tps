package src;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import src.problemas.Ej1;

public class Tp1{


	@Test
	public void mdecreciente(){
		
		assertEquals( 0, Ej1.buscarGanancia( new int[] { 4, 3,2,1 } ) );

	}
	
}