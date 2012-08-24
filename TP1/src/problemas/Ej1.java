package src.problemas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Ej1 {
	
	public static void abrir(){
		/*		StringTokenizer st = new StringTokenizer("this is a test");
				while (st.hasMoreTokens()) {
					System.out.println(st.nextToken());
				}*/
			//	System.out.println("temporal saraseitor is temporal\n");
				try{
				BufferedReader reader  = new BufferedReader( new FileReader( "/users/Juanma/code/TP1Algo3/tp1/Tp1Ej1.in" ) );
				String linea;
				
				while ((linea = reader.readLine()) != null){
					// Print the content on the console
//					System.out.println (linea);
					leer(linea);
					
				}
				//Close the input stream
				reader.close();
				}catch (Exception e){//Catch exception if any
					System.err.println("Error: " + e.getMessage());
				}
			}
			
			private static int[] leer( String string ) {
				   StringTokenizer st = new StringTokenizer( string, " " );
				   int tam = st.countTokens();
				   int[] precios = new int[tam];
				   int pos = 0;
				   while (st.hasMoreTokens()){
					   precios[pos] = Integer.parseInt(st.nextToken().trim());
					   pos++;
				   }
				   return precios;
			}
			
			private static void resolver(int[] precios){
				
			}

}
