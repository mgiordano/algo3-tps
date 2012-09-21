function plotEj1

	A = armarMatrizC;
	B = armarMatrizD;	
	C = armarMatrizR;
	
	%datos creciente
	y1 = podar(A);
	
	%datos decreciente
	y2 = podar(B);
	
	%datos random
	y3 = podar(C);
		
	x = zeros(size(y1,1),1);
	
	for i=1:size(x,1)
		x(i) = i*500;
	end
	
	%Buscamos aproximacion a los puntos
	P1 = polyfit(x,y1,1);
	P2 = polyfit(x,y2,1);
	P3 = polyfit(x,y3,1); 
	
	%calculamos recta aprox.
	y1p = P1(1) * x + P1(2);
	y2p = P2(1) * x + P2(2);
	y3p = P3(1) * x + P3(2);
	
	%ploteamos todo
	plot(x,y1,"@61");
	hold on;
	plot(x,y2,"@62");
	hold on;
	plot(x,y3,"@63");
	hold on;
	
	%ploteamos la aprox
	plot(x,y1p,"4");
	hold on;
	plot(x,y2p,"5");
	hold on;
	plot(x,y3p,"1");
	hold on;
	
	title("Tiempo de Corrida Ejercicio 1")
	xlabel("n = Cantidad de Dias")
	ylabel("T(n) en nanosegundos")
	legend("Caso Creciente", "Caso Decreciente","Caso Random","Aprox Creciente","Aprox Decreciente", "Aprox Random", "location", "northwest")
	legend("boxon")
	hold off;
	
end
