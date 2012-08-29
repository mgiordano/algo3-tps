package src.problemas;


public class Liston {
	public int largo;
	private int[] cortes;
	public int[][] solucion;
	public int[][] costos;
	
	public Liston(int largoInicial, int[] cortesInicial){
		int m = cortesInicial.length;
		largo = largoInicial;
		cortes = cortesInicial;
		solucion = new int[m][m];
		costos = new int[m][m];
		
		for(int j = 0; j < m; j++ ){
			for(int i = 0; i < m; i++ ){
				costos[j][i] = Integer.MAX_VALUE;
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
	
	public int dameCosto(int i, int j){
		return costos[i][j];
	}
	
	public void insertarCosto(int i, int j, int costo){
		costos[i][j] = costo;
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
