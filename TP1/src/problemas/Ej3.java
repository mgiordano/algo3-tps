package src.problemas;


public class Ej3 {

	public static int[] cortarListon(Liston liston){
		
		
		return liston.solucion;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static int costo(int largo, int[] cortes){
		int[][] costo = new int[cortes.length][cortes.length];
		for(int j = 0; j < (cortes.length); j++ ){
			for(int i = 0; i < (cortes.length); i++ ){
				costo[j][i] = Integer.MAX_VALUE;
			}
		}
		return memoizedCosto(cortes, costo, 0, cortes.length-1, 0, largo);

	}
	
	public static int memoizedCosto(int[] cortes, int[][] costo, int i, int j, int izq, int der){
		int z,x;
		if (costo[0][costo.length-1] < Integer.MAX_VALUE){
			return costo[0][costo.length-1];
		}
		if( i == j ){
			if(cortes[i] == izq || cortes[j] == der){
				return 0;
			}else{
				//System.out.println("lala ");
				//System.out.println(der-izq);
				return der - izq;
			}
		}else{
			int q = Integer.MAX_VALUE;
			for(int k = i; k < j; k++){
				if (costo[i][k] < Integer.MAX_VALUE){
					x = costo[i][k]; 
				}else{
					x = memoizedCosto(cortes, costo, i, k, izq, cortes[k]);
				}
				if (costo[k+1][j] < Integer.MAX_VALUE){
					z = costo[k+1][j]; 
				}else{
					z = memoizedCosto(cortes, costo, k+1, j, cortes[k], der);
				}
				q = Math.min(q, x + z + (der-izq));
			}
			costo[i][j] = q;
			//System.out.println(q);
			return q;
		}
		
		
	
	
	}
	}

		
	