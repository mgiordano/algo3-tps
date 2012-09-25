package src;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import src.problemas.Ej2;
import src.problemas.Investigador;
import src.problemas.Relaciones;
//import static org.junit.Assert.assertArrayEquals;


public class Tests2 {

	@Test
	public void testInvestigador(){
		
		// Test constructor basico de nombre "name"
		Investigador name = new Investigador("name");
		assertEquals("name", name.nombre);

		// Test de cambio de estado
		
		// Primero vemos que se crea con el estado "no encontrado"
		assertEquals("no encontrado", name.estado);
		// Luego se modifica y se vuelve a chequear para los otros estados
		name.encontrado();
		assertEquals("encontrado", name.estado);
		name.visitado();
		assertEquals("visitado", name.estado);

		// Test de distancia
		
		/* 
		 * Primero vemos que se crea con el valor mximo que puede tener
		 * un Integer, para que quede ese valor en caso de que el grafo
		 * de relaciones sea no conexo.
		 */
		assertEquals(Integer.MAX_VALUE, name.distancia);
		
		/*
		 * Seteamos la distancia en 0 como se hace a la hora de utilizarla
		 * por primera vez, y la aumentamos con la funcin aumentar
		*/
		name.distancia = 0;
		assertEquals(0, name.distancia);
		name.aumentar();
		assertEquals(1, name.distancia);

		// Test de agregar amigo
		
		// Creamos 2 amigos y los agregamos a name
		Investigador amigo1 = new Investigador("amigo1");
		Investigador amigo2 = new Investigador("amigo2");
		
		// Vemos que tanto amigo1 como amigo2 ahora son amigos de name
		name.AgregarAmigo(amigo1);
		name.AgregarAmigo(amigo2);
		assertEquals(amigo1, name.amistades.get(0));
		assertEquals(amigo2, name.amistades.get(1));
	}

	@Test
	public void testRelaciones(){
		
		// Test de constructor
		
		/*
		 * Creamos una instancia de la clase Relaciones, sin investigadores
		 * con un investigador fuente p, y un investigador destino q
		 */
		
		ArrayList<Investigador> invList = new ArrayList<Investigador>();
		Investigador p = new Investigador("p");
		Investigador q = new Investigador("q");
		Investigador r = new Investigador("r");
		
		Relaciones relacionTest = new Relaciones(invList, p, q);
		
		/*
		 * Veamos que el conjunto de investigadores es un arreglo vaco,
		 * comparando con el constructor vaco de un arreglo de investigadores
		 * y mostrando que la cantidad de elementos de dicho campo es 0.
		 */
		assertEquals(new ArrayList<Investigador>(), relacionTest.investigadores);
		assertEquals(0, relacionTest.investigadores.size());
		
		/*
		 * Veamos que los campos source (fuente) y destination (destino) del
		 * grafo, posteriormente utilizados para el algoritmo BFS, se asignan
		 * de manera correcta.
		 */
		
		assertEquals(p, relacionTest.source);
		assertEquals(q, relacionTest.destination);

		// Test setSource y setDest
		
		/*
		 * Intercambiamos investigador fuente y destino
		 */
		
		relacionTest.setDest(p);
		relacionTest.setSource(q);
		
		assertEquals(q, relacionTest.source);
		assertEquals(p, relacionTest.destination);
		
		
		// Test de agregar investigador
		
		/*
		 * Veamos que al agregar a p y a q como investigadores, aparecen como tales
		 */
		
		relacionTest.AgregarInvestigador(p);
		relacionTest.AgregarInvestigador(q);
		assertEquals(p, relacionTest.investigadores.get(0)); // Como p es el primero que agregamos, est en la posicin 0
		assertEquals(q, relacionTest.investigadores.get(1)); // Por el mismo motivo, q est en la posicin 1
		
		/*
		 * Veamos que ninguno tiene amigos, y luego testeamos la funcin para agregar
		 * amigos a ambos.
		 */
		
		assertEquals(0, relacionTest.investigadores.get(0).amistades.size());
		assertEquals(0, relacionTest.investigadores.get(1).amistades.size());
		
		p.AgregarAmigo(q);
		
		/*
		 * Vemos que cada uno tiene 1 amigo
		 */
		
		assertEquals(1, relacionTest.investigadores.get(0).amistades.size());
		assertEquals(1, relacionTest.investigadores.get(1).amistades.size());
		
		/*
		 * Vemos que el amigo de p es q y viceversa. Se puede acceder a los
		 * amigos desde el objeto investigador y desde las relaciones.
		 */
		
		assertEquals(q, p.amistades.get(0));
		assertEquals(p, q.amistades.get(0));
		assertEquals(q, relacionTest.investigadores.get(0).amistades.get(0));
		assertEquals(p, relacionTest.investigadores.get(1).amistades.get(0));
		
		/*
		 * A un investigador r, vamos a agregarle primero a q como amigo y luego a p
		 * y mostrar que los agrega bien, en rden, y que cada uno tiene los amigos
		 * que debe tener.
		 */
		
		r.AgregarAmigo(q);
		r.AgregarAmigo(p);
		
		relacionTest.AgregarInvestigador(r);
		
		assertEquals(q, relacionTest.investigadores.get(2).amistades.get(0));
		assertEquals(p, relacionTest.investigadores.get(2).amistades.get(1));
		
		// Tiene 2 amigos
		assertEquals(2, r.amistades.size());
		
		
		// r es amigo de p y q
		assertEquals(r, p.amistades.get(1));
		assertEquals(r, q.amistades.get(1));
		
	}

	@Test
	public void testC1(){
		Investigador esteban = new Investigador("esteban");
		Investigador irene = new Investigador("irene");
		
		ArrayList<Investigador> investigadores = new ArrayList<Investigador>();
		investigadores.add(esteban);
		investigadores.add(irene);
		
		Relaciones relacion = new Relaciones(investigadores, esteban, irene);
		int res = relacion.BFS(esteban, irene);
		System.out.println("El resultado es " + res);
		
		assertEquals(0, res);
		
	}

	@Test
	public void testC2(){
		
		Investigador esteban = new Investigador("esteban");
		Investigador irene = new Investigador("irene");
		Investigador alejandro = new Investigador("alejandro");
		Investigador paula = new Investigador("paula");
		esteban.AgregarAmigo(alejandro);
		irene.AgregarAmigo(alejandro);
		paula.AgregarAmigo(alejandro);
		
		alejandro.dameAmigos();
		irene.dameAmigos();
		paula.dameAmigos();
		esteban.dameAmigos();
		
		ArrayList<Investigador> investigadoresLocos = new ArrayList<Investigador>();
		investigadoresLocos.add(irene);
		investigadoresLocos.add(alejandro);
		investigadoresLocos.add(esteban);
		investigadoresLocos.add(paula);
		
		Relaciones prueba = new Relaciones(investigadoresLocos, esteban, irene);
		int res = prueba.BFS(esteban, irene);
		System.out.println("la distancia entre esteban e irene es " + res);
		
		assertEquals(2, res);
	}

	@Test
	public void testC3(){
		Investigador esteban = new Investigador("esteban");
		Investigador irene = new Investigador("irene");
		Investigador alejandro = new Investigador("alejandro");
		Investigador paula = new Investigador("paula");
		Investigador marina = new Investigador("marina");
		
		marina.AgregarAmigo(esteban);
		alejandro.AgregarAmigo(irene);
		paula.AgregarAmigo(alejandro);
		
		alejandro.dameAmigos();
		marina.dameAmigos();
		
		ArrayList<Investigador> investigadores = new ArrayList<Investigador>();
		investigadores.add(esteban);
		investigadores.add(irene);
		investigadores.add(alejandro);
		investigadores.add(paula);
		investigadores.add(marina);
		
		Relaciones relacion = new Relaciones(investigadores, esteban, irene);
		int res = relacion.BFS(esteban, irene);
		System.out.println("El resultado es " + res);
		
		assertEquals(0, res);
	}

	@Test
	public void testC4(){
		Investigador esteban = new Investigador("esteban");
		Investigador irene = new Investigador("irene");
		Investigador alejandro = new Investigador("alejandro");
		Investigador paula = new Investigador("paula");
		Investigador marina = new Investigador("marina");
		
		marina.AgregarAmigo(esteban);
		alejandro.AgregarAmigo(irene);
		paula.AgregarAmigo(alejandro);
		
		alejandro.dameAmigos();
		marina.dameAmigos();
		
		ArrayList<Investigador> investigadores = new ArrayList<Investigador>();
		investigadores.add(esteban);
		investigadores.add(irene);
		investigadores.add(alejandro);
		investigadores.add(paula);
		investigadores.add(marina);
		
		Relaciones relacion = new Relaciones(investigadores, esteban, irene);
		int res = relacion.BFS(esteban, irene);
		System.out.println("El resultado es " + res);
		
		assertEquals(0, res);
	}
	
	@Test
	public void testC5(){
		Investigador esteban = new Investigador("esteban");
		Investigador irene = new Investigador("irene");
		Investigador alejandro = new Investigador("alejandro");
		Investigador paula = new Investigador("paula");
		Investigador emilio = new Investigador("emilio");
		
		irene.AgregarAmigo(alejandro);
		irene.AgregarAmigo(paula);
		irene.AgregarAmigo(emilio);
		irene.AgregarAmigo(esteban);
		
		irene.dameAmigos();
		emilio.dameAmigos();
		
		ArrayList<Investigador> investigadores = new ArrayList<Investigador>();
		investigadores.add(esteban);
		investigadores.add(irene);
		investigadores.add(alejandro);
		investigadores.add(paula);
		investigadores.add(emilio);
		
		Relaciones relacion = new Relaciones(investigadores, esteban, irene);
		int res = relacion.BFS(esteban, irene);
		System.out.println("El resultado es " + res);
		
		assertEquals(1, res);
	}
	
	@Test
	public void testC6(){
		Investigador esteban = new Investigador("esteban");
		Investigador irene = new Investigador("irene");
		Investigador alejandro = new Investigador("alejandro");
		Investigador paula = new Investigador("paula");
		Investigador emilio = new Investigador("emilio");
		Investigador marina = new Investigador("marina");
		
		irene.AgregarAmigo(alejandro);
		irene.AgregarAmigo(paula);
		paula.AgregarAmigo(emilio);
		emilio.AgregarAmigo(esteban);
		emilio.AgregarAmigo(marina);
		
		irene.dameAmigos();
		emilio.dameAmigos();
		marina.dameAmigos();
		alejandro.dameAmigos();
		
		ArrayList<Investigador> investigadores = new ArrayList<Investigador>();
		investigadores.add(esteban);
		investigadores.add(irene);
		investigadores.add(alejandro);
		investigadores.add(paula);
		investigadores.add(emilio);
		investigadores.add(marina);
		
		Relaciones relacion = new Relaciones(investigadores, esteban, irene);
		int res = relacion.BFS(esteban, irene);
		System.out.println("El resultado es " + res);
		
		assertEquals(3, res);
	}
	
	@Test
	public void testC7(){
		Investigador esteban = new Investigador("esteban");
		Investigador irene = new Investigador("irene");
		Investigador alejandro = new Investigador("alejandro");
		Investigador paula = new Investigador("paula");
		Investigador emilio = new Investigador("emilio");
		Investigador marina = new Investigador("marina");
		
		irene.AgregarAmigo(alejandro);
		irene.AgregarAmigo(paula);
		paula.AgregarAmigo(emilio);
		emilio.AgregarAmigo(esteban);
		emilio.AgregarAmigo(marina);
		alejandro.AgregarAmigo(marina);
		
		irene.dameAmigos();
		emilio.dameAmigos();
		marina.dameAmigos();
		alejandro.dameAmigos();
		
		ArrayList<Investigador> investigadores = new ArrayList<Investigador>();
		investigadores.add(esteban);
		investigadores.add(irene);
		investigadores.add(alejandro);
		investigadores.add(paula);
		investigadores.add(emilio);
		investigadores.add(marina);
		
		Relaciones relacion = new Relaciones(investigadores, esteban, irene);
		int res = relacion.BFS(esteban, irene);
		System.out.println("El resultado es " + res);
		
		assertEquals(3, res);
	}
	
	@Test
	public void testLineal(){
		Investigador esteban = new Investigador("esteban");
		Investigador alejandro = new Investigador("alejandro");
		Investigador paula = new Investigador("paula");
		Investigador emilio = new Investigador("emilio");
		Investigador marina = new Investigador("marina");
		Investigador santiago = new Investigador("santiago");
		Investigador mauro = new Investigador("mauro");
		Investigador lucas = new Investigador("lucas");
		Investigador juanma = new Investigador("juanma");
		Investigador irene = new Investigador("irene");
		
		esteban.AgregarAmigo(alejandro);
		alejandro.AgregarAmigo(paula);
		paula.AgregarAmigo(emilio);
		emilio.AgregarAmigo(marina);
		marina.AgregarAmigo(santiago);
		santiago.AgregarAmigo(mauro);
		mauro.AgregarAmigo(lucas);
		lucas.AgregarAmigo(juanma);
		juanma.AgregarAmigo(irene);
		
		ArrayList<Investigador> investigadores = new ArrayList<Investigador>();
		investigadores.add(esteban);
		investigadores.add(alejandro);
		investigadores.add(paula);
		investigadores.add(emilio);
		investigadores.add(marina);
		investigadores.add(santiago);
		investigadores.add(mauro);
		investigadores.add(lucas);
		investigadores.add(juanma);
		investigadores.add(irene);
		
		Relaciones relacion = new Relaciones(investigadores, esteban, irene);
		int res = relacion.BFS(esteban, irene);
		System.out.println("El resultado es " + res);
		
		assertEquals(9, res);
	}
	
	@Test
	public void todosVStodos(){
		Investigador esteban = new Investigador("esteban");
		Investigador alejandro = new Investigador("alejandro");
		Investigador paula = new Investigador("paula");
		Investigador emilio = new Investigador("emilio");
		Investigador marina = new Investigador("marina");
		Investigador irene = new Investigador("irene");
		
		esteban.AgregarAmigo(alejandro);
		esteban.AgregarAmigo(paula);
		esteban.AgregarAmigo(emilio);
		esteban.AgregarAmigo(marina);
		esteban.AgregarAmigo(irene);
		alejandro.AgregarAmigo(paula);
		alejandro.AgregarAmigo(emilio);
		alejandro.AgregarAmigo(marina);
		alejandro.AgregarAmigo(irene);
		paula.AgregarAmigo(emilio);
		paula.AgregarAmigo(marina);
		paula.AgregarAmigo(irene);
		emilio.AgregarAmigo(marina);
		emilio.AgregarAmigo(irene);
		marina.AgregarAmigo(irene);
		
		ArrayList<Investigador> investigadores = new ArrayList<Investigador>();
		investigadores.add(esteban);
		investigadores.add(alejandro);
		investigadores.add(paula);
		investigadores.add(emilio);
		investigadores.add(marina);
		investigadores.add(irene);
		
		Relaciones relacion = new Relaciones(investigadores, esteban, irene);
		int res = relacion.BFS(esteban, irene);
		System.out.println("El resultado es " + res);
		
		assertEquals(1, res);
	}
	
	@Test
	public void testLeer() throws IOException{
		Ej2.resolverFile("./tests/Tp1Ej2.in");
	}
	
	@Test
	public void testNoConexos() throws IOException{
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/noConexos10000alFinal.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/noConexos10000alMedio.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/noConexos10000alPrincipioo.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/noConexos20000alFinal.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/noConexos20000alMedio.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/noConexos20000alPrincipio.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/noConexos30000alFinal.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/noConexos30000alMedio.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/noConexos30000alPrincipio.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/noConexos40000alFinal.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/noConexos40000alMedio.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/noConexos40000alPrincipio.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/noConexos50000alFinal.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/noConexos50000alMedio.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/noConexos50000alPrincipio.in");
	
	}
	
	@Test
	public void testRandom() throws IOException{
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/rand5000.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/rand10000.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/rand20000.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/rand30000.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/rand40000.in");
		Ej2.resolverFile("./tests/testsAvanzados/Ej2/rand50000.in");	
	}
	
}
