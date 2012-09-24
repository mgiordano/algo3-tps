function plotCF
	
	%Cargamos los datos - sabemos que cada caso comprende 10 lineas = iteraciones
	v = load("dataCF.txt");

	%cantidad de casos
	tam = length(v)/10;

	%armamos la matriz de datos vacía
	A = zeros(tam,2);

	i = 1;
	j = 500;
	for k=1:size(A,1)
		j = 500 + i - 1;
		A(k,1) = j;
		A(k,2) = podar(v(i:i+9));
		i = i+10;
	end
	
	x = A(:,1);
	y = A(:,2);

	%elimino outliers que sobrevivieron a la poda para aproximar linealmente sin contemplarlos
	y2 = zeros(length(y),1);
	for l=1:length(y2)
		if y(l) > 150
			y2(l) = 150;  %saturamos los puntos, restando importancia a los outliers en la aprox
		else
			y2(l) = y(l);
		end
	end
	
	%aproximamos mirando la mayor densidad
	P = polyfit(x,y2,1);
	
	y3 = P(1) * x(1) + P(2);

	plot(x,y,"@62");
	hold on;
	plot(x,y3,"-@11");
	hold on;
	title("Tiempo de Corrida para Variacion Liston con #Cortes = 11")
	xlabel("n = Largo Liston")
	ylabel("T(n) en milisegundos")
	legend("Valores Caso Fijo", "Fitness Lineal","location", "northwest")
	legend("boxon")
	hold off;
end
