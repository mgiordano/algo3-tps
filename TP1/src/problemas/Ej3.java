package src.problemas;

public class Ej3 {

	public static Solucion cortarListon(Liston liston){
		int m = liston.cantCortes()-1; 
		Solucion solucion = memoizedCosto(liston, 0, m, 0, liston.largo);
		return solucion;
	}
	
	public static Solucion memoizedCosto(Liston liston, int i, int j, int izq, int der){	
		Solucion solIzq = new Solucion(), solDer = new Solucion(), sol_ij = new Solucion();
		//Dos casos base posible: se quiere cortar un extremo (invalido) o se realiza un solo corte en un liston.
		if( i == j ){
			if(liston.dameCorte(i) == izq || liston.dameCorte(j) == der){
				Solucion corteInvalido = new Solucion();
				return corteInvalido;
			}else{
				Solucion corteBase = new Solucion(der - izq, liston.dameCorte(i));
				return corteBase;
			}
		}else{
			int costoAnt = Integer.MAX_VALUE;
			int ktmp = 0, costoAct;
			//En un conjunto de cortes asociado a un liston, busco cortar k-esimo tal que el costo sea optimo.
			for(int k = i; k < j; k++){
				//Para ambos subproblemas generados (a izq y der de k), busco si la solParcial fue calculada
				//sino se llama recursivamente para obtener el costo optimo.
				if (liston.haySolucion(i,k)){
					solIzq = liston.dameSolucion(i,k); 
				}else{
					solIzq = memoizedCosto(liston, i, k, izq, liston.dameCorte(k));
				}
				if (liston.haySolucion(k+1,j)){
					solDer = liston.dameSolucion(k+1,j); 
				}else{
					solDer = memoizedCosto(liston, k+1, j, liston.dameCorte(k), der);
				}
				//Se calcula el costo final para ese corte k y se evalua si es menor a los calculado para los k anteriores
				costoAct = solIzq.costo + solDer.costo + (der-izq);
				if (costoAct < costoAnt){
					costoAnt = costoAct;
					ktmp = k;
					//Si el costo fue optimo, se genera una nueva solucion combinando la historia de cortes de los
					//subproblemas izq y der junto con el corte actual y la suma de esos costos.
					sol_ij = Solucion.combinar(solIzq,solDer,costoAnt,liston.dameCorte(ktmp));
				}
			}
			//Se guarda la solucion optima para el conjunto de cortes i al j.
			liston.insertarSolucion(i,j,sol_ij);
			return sol_ij;
		}
	}

}
	