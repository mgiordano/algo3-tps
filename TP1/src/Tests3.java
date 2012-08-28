package src;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import src.problemas.Ej3;

public class Tests3 {
	
	@Test
	public void test2(){
		Integer[] lala = new Integer[] {2,4,7};
		List<Integer> prueba = Arrays.asList(lala);
		assertArrayEquals( new Integer[] {4,2,7} , Ej3.cortarListon(10, prueba).toArray(new Integer[prueba.size()]));
	}
	
	@Test
	public void test1(){
		Integer[] lala = new Integer[] {4,5,7,8};
		List<Integer> prueba = Arrays.asList(lala);
		assertArrayEquals( new Integer[] {4,7,5,8} , Ej3.cortarListon(10, prueba).toArray(new Integer[prueba.size()]));
		
		
	}

}
