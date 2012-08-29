package src.problemas;

public class Liston {
	public int largo;
	private int[] cortes;
	public int[] solucion;
	private int[][] costos;
	
	public Liston(int largoInicial, int[] cortesInicial){
		int m = cortesInicial.length;
		largo = largoInicial;
		cortes = cortesInicial;
		solucion = new int[m];
		costos = new int[m][m];
	}
	
	public int dameCorte(int pos){
		return cortes[pos];
	}
		
	public void insertarSolucion(int pos, int nuevaSol){
		solucion[pos] = nuevaSol;
	}
	
	public int dameCosto(int i, int j){
		return costos[i][j];
	}
	
	public void insertarCosto(int i, int j, int costo){
		costos[i][j] = costo;
	}
	
	
}
