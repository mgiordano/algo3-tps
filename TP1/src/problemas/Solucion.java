package src.problemas;

import java.util.ArrayList;
import java.util.List;

public class Solucion{
	
	public int costo;
	public List<Integer> cortes;
	
	public Solucion(){
		costo = 0;
		cortes = new ArrayList<Integer>();
	}
	
	public Solucion(int costoVal, int corte){
		costo = costoVal;
		cortes = new ArrayList<Integer>();
		cortes.add(corte);
	}
	
	public static Solucion combinar(Solucion a, Solucion b, int val, int corte){
		Solucion res = new Solucion();
		res.costo = val;
		res.cortes.add(corte);
		res.cortes.addAll(a.cortes);
		res.cortes.addAll(b.cortes);
		return res;
		
	}
	
}