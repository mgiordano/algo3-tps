function A = plotDU
	
	%Cargamos los datos
	A = load("dataDUm.txt");
	C = load("dataDUt.txt");
	tam = size(C,1);
	B = zeros(tam);

	x = A(:,1);
	y = C(:,1);

	%Buscamos el polinomio cubico que mejor aproxima
	%el set de datos.
	P = polyfit(x,y,3)

	%calculamos el polinomio aprox.
	y2 = P(1)*(x.^3) + P(2)*(x.^2) + P(3)*x + P(4);

	%calculamos el orden cuadrado de los datos de entrada
	y3 = (x.^3)*0.00025;

	
	%graficamos ambos
	plot(x,y,"@62");
	hold on;
	plot(x,y2);
	plot(x,y3,"1");
	title("Tiempo de Corrida Distribucion Uniforme")
	xlabel("m = Cantidad de Cortes")
	ylabel("T(n) en milisegundos")
	legend("Valores Uniforme", "Fitness Cubico","0.00025*m^3","location", "northwest")
	legend("boxon")
	hold off;

end
