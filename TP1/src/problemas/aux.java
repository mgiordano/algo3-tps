package src.problemas;

import java.util.Arrays;
import java.util.List;

public class aux {
	
	public static List<Integer> concat(List<Integer> a, List<Integer> b, List<Integer> c) {
		
		Integer[] first = a.toArray(new Integer[a.size()]);
		Integer[] second = b.toArray(new Integer[b.size()]);
		Integer[] third = c.toArray(new Integer[c.size()]);
		Integer[] result = concatAll(first,second,third);
		List<Integer> conc = Arrays.asList(result);
		return conc;
		
		}
	
	private static <T> T[] concatAll(T[] first, T[]... rest) {
		  int totalLength = first.length;
		  for (T[] array : rest) {
		    totalLength += array.length;
		  }
		  T[] result = Arrays.copyOf(first, totalLength);
		  int offset = first.length;
		  for (T[] array : rest) {
		    System.arraycopy(array, 0, result, offset, array.length);
		    offset += array.length;
		  }
		  return result;
		}
	
}
