Readme: Generadores de casos de test para el ejercicio 2

Estas instrucciones son válidas para todos los casos de test del ejercicio 2. Los mismos se hacen con los archivos

1 - cadenaFull.cpp: Grafo cadena con p = 1 y q = número ingresado por consola (de punta a punta).
2 - cadenaRand.cpp: Grafo cadena con p y q random entre 1 y el número ingresado por consola.
3 - grafoCompleto.cpp: Grafo completo, todos son amigos de todos.
4 - rand.cpp: Grafo random, se sabe la cantidad de investigadores pero no la cantidad de amistades.

Para compilarlos, en consola ejecutar

	g++ -o nombreEjecutable nombreFuente.cpp

Para utilizarlos, en consola ejecutar

	./nombreEjecutable

Una vez que se presiona enter, se espera un número de entrada que varía según que archivo se ejecute. El número a ingresar es la cantidad de investigadores deseada en el grafo.

Al terminar la ejecución del programa, se mostrará por consola un grafo de forma apta para utilizar el in/out de nuestro programa en java.

En caso de querer experimentar con el mismo, se puede copiar a mano (copiar la salida por pantalla, pegar en un archivo, y guardarlo) o al ejecutar agregar el comando para que lo guarde en un archivo

	./nombreEjecutable > nombreArchivo.in

Lo que guardará el grafo generado en nombreArchivo.in. Finalmente para utilizarlo en el programa, a la hora de usar la función, habría que cambiar el path en el cual va a buscar el archivo de entrada a resolver por el path deseado del archivo generado por consola.