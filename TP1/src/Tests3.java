package src;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import src.problemas.Ej3;

public class Tests3 {
	
	@Test
	public void test2(){
		assertEquals( 22 , Ej3.costo(10, new int[] {4,5,7,8}));
	}
	

}
