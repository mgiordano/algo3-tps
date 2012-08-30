package src.problemas;

import java.util.ArrayList;
import java.util.List;

public class CostoK{
	
	public int costo;
	public List<Integer> K;
	
	public CostoK(int costoVal, int k){
		
		costo = costoVal;
		K = new ArrayList<Integer>(k);
	}
	
	public CostoK (){
		
		costo = 0;
		K = new ArrayList<Integer>();
	}
	
	public static CostoK combinar(CostoK a, CostoK b, int val, int k){
		
		CostoK res = new CostoK();
		res.costo = val;
		res.K.addAll(a.K);
		res.K.add(k);
		res.K.addAll(b.K);
		
		return res;
		
	}
	
}