function plotDN
	
	%Cargamos los datos - sabemos que cada caso comprende 10 lineas = iteraciones
	v = load("dataDNt.txt");
	u = load("dataDNm.txt");

	%armamos la matriz de datos vacía
	A = zeros(length(u),2);

	i = 1;
	for k=1:size(A,1)
		A(k,1) = u(k);
		A(k,2) = podar(v(i:i+9));
		i = i+10;
	end
	
	x = A(:,1);
	y = A(:,2);
	
	%aproximamos con curva cúbica
	P = polyfit(x,y,3);
	
	y2 = P(1) * x.^3 + P(2) * x.^2 + P(3) * x + P(4);

	y3 = (x.^3)*0.00025;

	plot(x,y,"@62");
	hold on;
	plot(x,y2,"1");
	hold on;
	plot(x,y3);
	title("Tiempo de Corrida para Distribucion Normal")
	xlabel("m = Cantidad de Cortes")
	ylabel("T(m) en milisegundos")
	legend("Valores Caso Normal", "Fitness Cubico","0.00025*m^3","location", "northwest")
	legend("boxon")
	hold on;
end
