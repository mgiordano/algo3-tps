package src.problemas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.StringTokenizer;


public class Ej2{
	/*
	 * Funciones para resolver el problema
	 */
		
	
	public static void resolverFile(String file) throws IOException{
		/*
		 * Esta funcion toma el path del archivo de entrada, procesa los datos y llama
		 * a la funcion que resuelve el problema. Luego escribe los resultados en 
		 * un archivo de salida en la carpeta root del proyecto
		 */

			BufferedReader reader = new BufferedReader(new FileReader(file)); // Creo el buffer a llenar
			String linea; // Creo el string a utilizar (donde se van a guardar las cosas del buffer)
			BufferedWriter os = new BufferedWriter( new FileWriter( "Tp1Ej2.out" ) );
			int res;

			Investigador p = new Investigador(), q = new Investigador(), inv1 = new Investigador(), 
							inv2 = new Investigador();
			Relaciones relacion = new Relaciones();
			StringTokenizer nombre;
			ArrayList<Investigador> amistades = new ArrayList<Investigador>();
			// Leo el archivo
			
			while ((linea = reader.readLine()) != null){ // mientras que hayan mas lineas que leer
				// pongo todo en 0 para leer y resolver
				relacion  = new Relaciones();
				res = 0;
				amistades = new ArrayList<Investigador>();
				
				// leo la primera linea
				nombre = new StringTokenizer( linea, " ");
				
				// Paso el primer tokenizer, el p
				p = new Investigador(nombre.nextToken());
				relacion.setSource(p);
				
				// Paso el segundo tokenizer, el q
				q = new Investigador(nombre.nextToken());
				relacion.setDest(q);
				
				// leo la segunda linea
				linea = reader.readLine();
				StringTokenizer amistad = new StringTokenizer(linea, ";"); // Este token separa pares de amigos
				while (amistad.hasMoreTokens()){
					nombre = new StringTokenizer(amistad.nextToken(), " ");
					inv1 = new Investigador(nombre.nextToken());
					inv2 = new Investigador(nombre.nextToken());
					amistades.add(inv1);
					amistades.add(inv2);
				}
				// ahora en amistades tengo un array de investigadores, cada par son amigos
				// ademas en p tengo al source y en q al destination
				
				relacion.AgregarInvestigador(p);
				relacion.AgregarInvestigador(q);
				
				ListIterator<Investigador> parDeAmigos = amistades.listIterator();
				while (parDeAmigos.hasNext()){
					inv1 = parDeAmigos.next();
					inv2 = parDeAmigos.next();
					relacion.AgregarAmigos(inv1, inv2);
				}
				res = relacion.BFS(p, q);
				Integer res2 = res;
				os.append(res2.toString());
				os.append("\n");
			}
			reader.close();
			os.close();
	}
}
