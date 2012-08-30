package src.problemas;

import java.util.List;


public class Liston {
	public int largo;
	private int[] cortes;
	public int[][] solucion;
	public CostoK[][] costosK;
	
	public Liston(int largoInicial, int[] cortesInicial){
		int m = cortesInicial.length;
		largo = largoInicial;
		cortes = cortesInicial;
		solucion = new int[m][m];
		costosK = new CostoK[m][m];
		
		for(int j = 0; j < m; j++ ){
			for(int i = 0; i < m; i++ ){
				CostoK costoInit = new CostoK();
				costoInit.costo = Integer.MAX_VALUE;
				costosK[j][i] = costoInit;
			}
		}
	}
	
	public int cantCortes(){
		return cortes.length;
	}
	
	public int dameCorte(int pos){
		return cortes[pos];
	}
	
	public int dameSolucion(int i, int j){
		return solucion[i][j];
	}
		
	public void insertarSolucion(int i, int j, int nuevaSol){
		solucion[i][j] = nuevaSol;
	}
	
	public CostoK dameCostoK(int i, int j){
		return costosK[i][j];
	}
	
	public int dameCosto(int i, int j){
		return costosK[i][j].costo;
	}
	
	public void insertarCosto(int i, int j, int val){
		costosK[i][j].costo = val;
	}
	
	public void insertarCostoK(int i, int j, CostoK val){
		costosK[i][j] = val;
	}
	
	public void insertarK(int i, int j, int val){
		costosK[i][j].K.add(val);
	}
	
	public List<Integer> obtenerListaK(int i, int j){
		return costosK[i][j].K;
	}
	
	
	/*
	 * AUXILIARES
	 */
	public void imprimir(int[][] matriz){
		int m = matriz.length;
		for(int j = 0; j < m; j++ ){
			for(int i = 0; i < m; i++ ){
				System.out.print(matriz[j][i]+" ");
			}
			System.out.println("");
		}
	}
}
