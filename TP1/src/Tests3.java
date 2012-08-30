package src;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

import src.problemas.Ej3;
import src.problemas.Liston;

public class Tests3 {
	
	@Test
	public void test3(){
		
		Liston liston1 = new Liston(10, new int[] {2,4,7});
		assertEquals( 20 , Ej3.cortarListon(liston1));
		
		System.out.println("****");
		
		Liston liston2 = new Liston(10, new int[] {4,5,7,8});
		assertEquals( 22 , Ej3.cortarListon(liston2));
		
		System.out.println("****");
		
		Liston liston3 = new Liston(100, new int[] {25,50,75});
		assertEquals( 200 , Ej3.cortarListon(liston3));
	}

}
