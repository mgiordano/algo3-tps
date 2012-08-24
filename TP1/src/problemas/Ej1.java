package src.problemas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class Ej1 {
	
	public static void resolver(){
		
		try{
		BufferedReader reader = new BufferedReader( new FileReader( "./src/Tp1Ej1.in" ) );
		String linea;
		
		BufferedWriter os = new BufferedWriter( new FileWriter( "Tp1Ej1.out" ) );
		while ((linea = reader.readLine()) != null){
			escribir( buscarGanancia( leer(linea) ), os);
		}
		os.close();
		reader.close();
		
		}catch (Exception e){
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
			
	private static int buscarGanancia(int[] precios){
		int min = precios[0], max = precios[0], tam = precios.length;
		int gananciaActual = 0;
		int gananciaMax = 0;
		for (int i = 1; i < tam; i++){
			if (precios[i] < min){
				min = precios[i];
				max = precios[i];
				
			}
			if (precios[i] > max){
				max = precios[i];
			}
			gananciaActual = max - min;
			if (gananciaActual > gananciaMax) gananciaMax = gananciaActual;
		}
		return gananciaMax;
	}
			
	private static void escribir(int res, BufferedWriter os){
		try{
			Integer resInt = res;
			os.append(resInt.toString());
			System.out.println(res);
			os.append('\n');
			
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}

}
