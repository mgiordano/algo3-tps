function x = podar(v)

	prom = sum(v(:,1)) / length(v);
	for i = 1: length(v)
		if errRel(v(i),prom) > 0.00001
			v(i) = 0;
		end
	end
	x = max(v);
end

