import java.util.ArrayList;
import java.util.HashSet;

public class Array_Common_Elements {
	public ArrayList<Integer> findCommon(int[] a, int[] b) {
		ArrayList<Integer> result = new ArrayList<Integer> ();
		if (a == null || a.length == 0 || b == null || b.length == 0) {
			return result;
		}
		
		HashSet<Integer> set = new HashSet<Integer> ();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		
		for (int j = 0; j < b.length; j++) {
			if (set.contains(b[j])) {
				result.add(b[j]);
				set.remove(b[j]);
			}
		}
		
		return result;
	}
}
