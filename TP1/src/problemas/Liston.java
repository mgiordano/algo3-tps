package src.problemas;

import java.util.List;

public class Liston {

	public int largo;
	private int[] cortes;
	public Solucion[][] solParciales;
	
	//Constructor Liston
		
	public Liston(int largoInicial, int[] cortesInicial){
		int m = cortesInicial.length;
		largo = largoInicial;
		cortes = cortesInicial;
		solParciales = new Solucion[m][m];
		
		for(int j = 0; j < m; j++ ){
			for(int i = 0; i < m; i++ ){
				Solucion solIni = new Solucion();
				solIni.costo = Integer.MAX_VALUE;
				solParciales[j][i] = solIni;
			}
		}
	}
		
	//Metodos de Liston
	
	public int cantCortes(){
		return cortes.length;
	}
	
	public int dameCorte(int pos){
		return cortes[pos];
	}
	
	public boolean haySolucion(int i, int j){
		return dameCosto(i,j) < Integer.MAX_VALUE;
	}
	
	public Solucion dameSolucion(int i, int j){
		return solParciales[i][j];
	}
	
	public void insertarSolucion(int i, int j, Solucion sol){
		solParciales[i][j] = sol;
	}
	
	public List<Integer> obtenerListaK(int i, int j){
		return solParciales[i][j].cortes;
	}
	
	//Metodos no usados por el momento
	
	public int dameCosto(int i, int j){
		return solParciales[i][j].costo;
	}
	
	public void insertarCosto(int i, int j, int val){
		solParciales[i][j].costo = val;
	}
	
	public void insertarK(int i, int j, int val){
		solParciales[i][j].cortes.add(val);
	}
	
	
}
