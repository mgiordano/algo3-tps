package src.problemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Ej3 {

	public static List<Integer> cortarListon(int tam, List<Integer> cortes){
		if (cortes.size() <= 1){
			return cortes;
		}else{
			double m = tam/2;
			Integer corte = corteCercanoAm(m,cortes);
			int corte_i = cortes.indexOf(corte);
			int tamCortes = cortes.size();
			List<Integer> listaIzq = cortes.subList(0, corte_i);
			List<Integer> listaDer = cortes.subList(corte_i+1, tamCortes);
			List<Integer> res = new ArrayList<Integer>();
			res.add(corte);
			return aux.concat(res,cortarListon(corte,listaIzq),cortarListon(tam-corte,listaDer));
		}

	}
	
	private static Integer corteCercanoAm(double m, List<Integer> cortes){
		
		Iterator<Integer> it = cortes.iterator();
		double distMin = 2*m + 1;
		Integer res = cortes.get(0);
		while (it.hasNext()){
			Integer corte = it.next();
			double dist = Math.abs(m-corte.intValue());
			if (dist < distMin){
				distMin = dist;
				res = corte;
			}
		}
		
		return res;
	}
	
}
