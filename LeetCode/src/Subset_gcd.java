import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Subset_gcd {
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (sc.hasNext()) {
                list.add(sc.nextInt());
            } else {
                throw new Exception("Invalid input!");
            }
        }
        
        HashMap<Integer, Integer> mapDup = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> mapSubset = new HashMap<Integer, Integer>();
        int maxValue = 0;
        int tmp = 0;
        
        for (int i = 0; i < list.size(); i++) {
        	tmp = list.get(i);
        	if (tmp > maxValue) {
        		maxValue = tmp;
        	}
        	if (mapDup.containsKey(tmp)) {
        		mapDup.put(tmp, mapDup.get(tmp) + 1);
        	} else {
        		mapDup.put(tmp, 1);
        	}
        }
        
        for (int i = maxValue; i > 0; i++) {
        	int dup = 0; 
        	if (mapDup.containsKey(i)) {
        		dup = mapDup.get(i);
        	}
        	int subset = 0;
        	
        	for (int j = 0; j * i < maxValue; j++) {
        		if (mapDup.containsKey(j * i)) {
        			dup = dup + mapDup.get(j * i);
        		}
        		if (mapSubset.containsKey(j * i)) {
        			subset = subset + mapSubset.get(j * i);
        		}
        	}
        	
        	int value = (int)Math.pow(2, dup) - 1 - subset;
        	mapSubset.put(i, value);
        }
        
        for (int i = 0 ; i < list.size(); i++) {
        	System.out.print(mapSubset.get(list.get(i)));
        	System.out.print(" ");
        }
    }
}
