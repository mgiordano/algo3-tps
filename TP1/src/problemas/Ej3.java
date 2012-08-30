package src.problemas;


public class Ej3 {

	public static int cortarListon(Liston liston){
		
		int m = liston.cantCortes()-1; 
		int costo = memoizedCosto(liston, 0, m, 0, liston.largo).costo;
		System.out.println(liston.dameCosto(0, m));
		//reconstruirSol(liston,0,m);
		//liston.imprimir(liston.costosK);
		return costo;
	}
	
	public static CostoK memoizedCosto(Liston liston, int i, int j, int izq, int der){
		CostoK cortesIzq = new CostoK(), cortesDer = new CostoK(), cortes_ij = new CostoK();
		int m = liston.cantCortes()-1;
		/*if (liston.dameCosto(0, m) < Integer.MAX_VALUE){
			return liston.dameCostoK(0, m);
		}*/
		if( i == j ){
			if(liston.dameCorte(i) == izq || liston.dameCorte(j) == der){
				CostoK corteInvalido = new CostoK();
				return corteInvalido;
			}else{
				CostoK corteBase = new CostoK(der - izq, i);
				return corteBase;
			}
		}else{
			int qAnt = Integer.MAX_VALUE;
			int ktmp = 0, qAct;
			for(int k = i; k < j; k++){
			//	System.out.println(k);
				if (liston.dameCosto(i,k) < Integer.MAX_VALUE){
					cortesIzq = liston.dameCostoK(i,k); 
				}else{
					cortesIzq = memoizedCosto(liston, i, k, izq, liston.dameCorte(k));
				}
				if (liston.dameCosto(k+1,j) < Integer.MAX_VALUE){
					cortesDer = liston.dameCostoK(k+1,j); 
				}else{
					cortesDer = memoizedCosto(liston, k+1, j, liston.dameCorte(k), der);
				}
				qAct = cortesIzq.costo + cortesDer.costo + (der-izq);
				if (qAct < qAnt){
					qAnt = qAct;
					ktmp = k;
					cortes_ij = CostoK.combinar(cortesIzq,cortesDer,qAnt,ktmp);
				}
			}
			liston.insertarCostoK(i,j,cortes_ij);
			return cortes_ij;
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

		
	