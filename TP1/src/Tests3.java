package src;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import src.problemas.Liston;
import src.problemas.Ej3;

public class Tests3 {
	
	@Test
	public void test3(){
		Liston liston = new Liston(100, new int[] {25,50,75});
		assertEquals( 150 , Ej3.cortarListon(liston));
	}
	
	/*@Test
	public void test2(){
		Liston liston = new Liston(10, new int[] {4,5,7,8});
		assertArrayEquals(  new int[] {7,5,7,4} , Ej3.cortarListon(liston));
	}
	*/

}
