package src.problemas;


public class Ej3 {

	public static int cortarListon(Liston liston){
		
		int m = liston.cantCortes()-1; 
		int costo = memoizedCosto(liston, 0, m, 0, liston.largo);
		//reconstruirSol(liston,0,m);
		liston.imprimir(liston.costos);
		return costo;
	}
	
	public static int memoizedCosto(Liston liston, int i, int j, int izq, int der){
		int z,x;
		int m = liston.cantCortes()-1;
		if (liston.dameCosto(0, m) < Integer.MAX_VALUE){
			return liston.dameCosto(0, m);
		}
		if( i == j ){
			if(liston.dameCorte(i) == izq || liston.dameCorte(j) == der){
				return 0;
			}else{
				return der - izq;
			}
		}else{
			int qAnt = Integer.MAX_VALUE;
			int ktmp = 0;
			for(int k = i; k < j; k++){
				if (liston.dameCosto(i,k) < Integer.MAX_VALUE){
					x = liston.dameCosto(i,k); 
				}else{
					x = memoizedCosto(liston, i, k, izq, liston.dameCorte(k));
				}
				if (liston.dameCosto(k+1,j) < Integer.MAX_VALUE){
					z = liston.dameCosto(k+1,j); 
				}else{
					z = memoizedCosto(liston, k+1, j, liston.dameCorte(k), der);
				}
				int qAct = x + z + (der-izq);
				if (qAct < qAnt){
					qAnt = qAct;
					ktmp = k;
				}
			}
			liston.insertarSolucion(i,j,ktmp);
			liston.insertarCosto(i,j,qAnt);
			return qAnt;
		}
	}
	
	public static void reconstruirSol(Liston liston, int i, int j){
		
		if (i == j){
			System.out.print(liston.dameCorte(i)+" ");
		}else{
			reconstruirSol(liston,i,liston.dameSolucion(i,j));
			reconstruirSol(liston,liston.dameSolucion(i,j)+1,j);
		}
		
	}
	
}

		
	