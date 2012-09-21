function v = podar(A)

	B = A(101:end, :);
	tam_fila = size(B,1);
	tam_col = size(B,2);
	v = zeros(tam_col,1);

	for i = 1:tam_col
		suma = sum(B(:,i));
		prom = suma / tam_fila;
		for j = 1: tam_fila
			if errRel(B(j,i),prom) > 0.1
				B(j,i) = 0;
			end
		end
		v(i) = max(B(:,i));
	end
end
