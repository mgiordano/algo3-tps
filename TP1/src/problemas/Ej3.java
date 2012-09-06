package src.problemas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.StringTokenizer;

public class Ej3 {
	
	/*
	 * Funciones para resolver el problema
	 */

	public static Solucion cortarListon(Liston liston){
		int m = liston.cantCortes(); 
		Solucion solucion = memoizedCosto(liston, 0, m-1, 0, liston.largo);
		return solucion;
	}
	
	public static Solucion memoizedCosto(Liston liston, int i, int j, int izq, int der){	
		Solucion solIzq = new Solucion(), solDer = new Solucion(), sol_ij = new Solucion();
		//Dos casos base posibles: se quiere cortar un extremo (invalido) o se realiza un solo corte en un liston.
		if( i == j ){
			if(liston.dameCorte(i) == izq || liston.dameCorte(j) == der){
				Solucion corteInvalido = new Solucion();
				liston.insertarSolucion(i,j,corteInvalido);
				return corteInvalido;
			}else{
				Solucion corteBase = new Solucion(der - izq, liston.dameCorte(i));
				liston.insertarSolucion(i,j,corteBase);
				return corteBase;
			}
		}else{
			int costoAnt = Integer.MAX_VALUE;
			int ktmp = 0, costoAct;
			//En un conjunto de cortes asociado a un liston, busco cortar k-esimo tal que el costo sea optimo.
			for(int k = i; k < j; k++){
				//Para ambos subproblemas generados (a izq y der de k), busco si la solParcial fue calculada
				//sino se llama recursivamente para obtener el costo optimo.
				if (!liston.haySolucion(i,k)){
					memoizedCosto(liston, i, k, izq, liston.dameCorte(k));
				}
				solIzq = liston.dameSolucion(i,k);
				if (!liston.haySolucion(k+1,j)){
					memoizedCosto(liston, k+1, j, liston.dameCorte(k), der);
				}
				solDer = liston.dameSolucion(k+1,j);
				//Se calcula el costo final para ese corte k y se evalua si es menor a los calculado para los k anteriores
				costoAct = solIzq.costo + solDer.costo + (der-izq);
				if (costoAct < costoAnt){
					costoAnt = costoAct;
					ktmp = k;
					//Si el costo fue optimo, se genera una nueva solucion combinando la historia de cortes de los
					//subproblemas izq y der junto con el corte actual y la suma de esos costos.
					sol_ij = Solucion.combinar(solIzq,solDer,costoAnt,liston.dameCorte(ktmp));
				}
			}
			//Se guarda la solucion optima para el conjunto de cortes i al j.
			liston.insertarSolucion(i,j,sol_ij);
			return sol_ij;
		}
	}
	
	/*
	 * Funciones para leer el input y escribir el output del Ejercicio 3
	 */
	
	public static void resolverFile(String file){
		/*
		 * Esta funcion toma el path del archivo de entrada, procesa los datos y llama
		 * a la función que resuelve el problema. Luego escribe los resultados en 
		 * un archivo de salida en la carpeta root del proyecto
		 */
		
		try{
		BufferedReader reader = new BufferedReader( new FileReader(file) );
		String linea;
		BufferedWriter os = new BufferedWriter( new FileWriter( "Tp1Ej3.out" ) );
		while ((linea = reader.readLine()) != null){
			StringTokenizer st = new StringTokenizer( linea, " " );
			int tamListon = Integer.parseInt(st.nextToken().trim());
			linea = reader.readLine();
			escribir( cortarListon(new Liston(tamListon, leer(linea) )), os);
		}
		os.close();
		reader.close();
		
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static int[] leer( String string ) {
		
		   StringTokenizer st = new StringTokenizer( string, " " );
		   int tam = st.countTokens();
		   int[] cortes = new int[tam];
		   int pos = 0;
		   while (st.hasMoreTokens()){
			   cortes[pos] = Integer.parseInt(st.nextToken().trim());
			   pos++;
		   }
		   return cortes;
		}
				
				
	private static void escribir(Solucion solucion, BufferedWriter os){
		try{
			List<Integer> cortes = solucion.cortes;
			for(int i = 0; i < cortes.size(); i++){
				os.append(cortes.get(i).toString());
				os.append(" ");
			}
			os.append('\n');
			
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}

}
	