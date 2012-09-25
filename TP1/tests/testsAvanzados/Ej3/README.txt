*****************************
Tests Avanzados Ejercicio 3
*****************************
-.-.-.-.-.-.-.-.-.-.-.
1. Archivos de test:
-.-.-.-.-.-.-.-.-.-.-.

	-------------------
	- distrUniforme.in
	-------------------
	Contiene varias instancias de testeo de este caso, donde se varía la cantidad de cortes distribuida en listones de tamaño 		variable de acuerdo a una distribución pareja y uniforme centrada en el medio del listón y separando cada corte por 2 unidades.
	
	-------------------
	- distrNormal.in
	-------------------
	Contiene varias instancias de testeo de este caso, donde se varía la cantidad de cortes distribuida en listones de tamaño 		variable de acuerdo a una distribución Normal con media el centro del listón y desvío estandar 10% del tamaño.

	-------------------
	- cortesFijo.in
	-------------------
	Contiene varias instancias de testeo de este caso, donde se fijó una cantidad de cortes igual a 11, ubicados en la zona izquierda 		del listón, a la vez que se varía el tamaño del mismo.

-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
2. Generadores de Archivos de test:
-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

	-------------------
	- generarDU.cpp
	-------------------
	Programa en c++ que permite generar un archivo de test con varias instancias del tipo distribución uniforme, de acuerdo a las 		características de este caso. Se puede variar la cantidad de casos y proporción de cortes por caso, así como también su ubicación 		relativa.

	-------------------
	- generarDN.cpp
	-------------------
	Programa en c++ que permite generar un archivo de test con varias instancias del tipo distribución normal, de acuerdo a las 		características de este caso. Se pueden variar los parámetros mu y sigma de la normal, la cantidad de casos y cortes a realizar, 	y los tamaños de los listones. Se debe tener cuidado que los parámetros elegidos de centrado y dispersión no generen números fuera 		de rango del listón.
	NOTA: Para compilar este programa con g++ se debe habilitar el flag -std=c++0x
	
	-------------------
	- generarCF.cpp
	-------------------
	Programa en c++ que permite generar un archivo de test con varias instancias del tipo cortes fijo de acuerdo a las 		características de este caso. Se puede variar la cantidad de cortes, y los tamaños de los listones.

-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-
3. Scripts de Octave para procesar los datos
-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-

	-------------------
	- errRel.m
	-------------------
	Calcula el error relativo entre dos números.

	-------------------
	- podar.m
	-------------------
	Toma un vector de datos, calcula el promedio y luego elimina los datos cuyo error relativo respecto al promedio sea mayor a un 		cierto porcentaje.

	-------------------
	- plotXX.m
	-------------------
	Script que se ocupa de procesar los respectivos datos (llamando a los scripts anteriores) y realizar los gráficos incluidos en el 		informe.

-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-
3. Archivos de Datos
-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-

	-Los restantes txt's contienen los tiempos de corrida y los valores de m ó n (dependiendo del test) obtenidos de la ejecución de 	los .in en Eclipse/Java y es el material que procesan los scripts de Octave.
	
	
	
