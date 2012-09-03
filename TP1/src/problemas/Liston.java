package src.problemas;

public class Liston {

	public int largo;
	public int[] cortes;
	private Solucion[][] solParciales;
	
	//Constructor Liston
		
	public Liston(int largoInicial, int[] cortesInicial){
		int m = cortesInicial.length;
		largo = largoInicial;
		cortes = cortesInicial;
		solParciales = new Solucion[m][m];
		
		for(int i = 0; i < m; i++ ){
			for(int j = i; j < m; j++ ){
				Solucion solIni = new Solucion();
				solIni.costo = Integer.MAX_VALUE;
				solParciales[i][j] = solIni;
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
		return solParciales[i][j].costo < Integer.MAX_VALUE;
	}
	
	public Solucion dameSolucion(int i, int j){
		return solParciales[i][j];
	}
	
	public void insertarSolucion(int i, int j, Solucion sol){
		solParciales[i][j] = sol;
	}
	
}
