package src.problemas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Ej2 {
	/*
	 * Funciones para resolver el problema
	 */
	
	ArrayList<Investigador> investigadores = new ArrayList<Investigador>();
		
	
	public static void resolverFile(String file){
		/*
		 * Esta funcion toma el path del archivo de entrada, procesa los datos y llama
		 * a la función que resuelve el problema. Luego escribe los resultados en 
		 * un archivo de salida en la carpeta root del proyecto
		 */
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file)); // Creo el buffer a llenar
			String linea; // Creo el string a utilizar (donde se van a guardar las cosas del buffer)
						
			String nombrep = new String();
			String nombreq = new String();
			Investigador p = new Investigador("p"), q = new Investigador("q"), temp1 = new Investigador("temp1"), temp2 = new Investigador("temp2");
			ArrayList<Investigador> listaInvestigadores = new ArrayList<Investigador>();
			Relaciones relacion = new Relaciones(listaInvestigadores, p, q);
			
			// Leo el archivo
			while ((linea = reader.readLine()) != null){ // mientras que hayan mas lineas que leer
				leerPrimeraLinea(linea, p, q, nombrep, nombreq, relacion);
				//relacion.ListarInvestigadores();
				linea = reader.readLine();
				leerSegundaLinea(linea, temp1, temp2, relacion);
				//relacion.ListarInvestigadores();
				int res = relacion.BFS(p, q);
				System.out.println("el resultado es " + res);
			}
			reader.close();
			
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}

	}
	
	public static void leerPrimeraLinea(String linea, Investigador p, Investigador q, String nombrep, String nombreq, Relaciones relacion){
		// Esta funci�n lee delimitando con espacios, los nombres p y q
		StringTokenizer nombre = new StringTokenizer( linea, " ");
		nombrep = nombre.nextToken().trim(); // Paso el primer tokenizer, el p
		p = new Investigador(nombrep);
		relacion.AgregarInvestigador(p);
		relacion.setSource(p);
		nombreq = nombre.nextToken().trim(); // Paso el segundo tokenizer, el q
		q = new Investigador(nombreq);
		relacion.AgregarInvestigador(q);
		relacion.setDest(q);
	}
	
	public static void leerSegundaLinea(String linea, Investigador temp1, Investigador temp2, Relaciones relacion){
		// Esta funci�n lee delimitando con punto y coma, las amistades
		StringTokenizer amistad = new StringTokenizer(linea, ";"); // Este token separa pares de amigos
		ArrayList<String> parDeAmigos = new ArrayList<String>();
		while (amistad.hasMoreTokens()){
			parDeAmigos.add(amistad.nextToken().trim());
		}
		int cantAmistades = parDeAmigos.size();
		int i = 0;

		while(i < cantAmistades){
			StringTokenizer nombre = new StringTokenizer(parDeAmigos.get(i), " "); // Este token separa, dentro de un par de amigos, cada uno
			String persona1 = nombre.nextToken().trim();
			String persona2 = nombre.nextToken().trim();
			temp1.nombre = persona1;
			temp2.nombre = persona2;

			temp1.AgregarAmigo(temp2);
			System.out.println(i);
			relacion.AgregarInvestigador(temp1);
			relacion.AgregarInvestigador(temp2);
			i++;
		}

	}
}
