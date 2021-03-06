import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode
 * 358. Rearrange String k Distance Apart
 * @author lorreina
 *
 */
public class Rearrange_String_k_Distance_Apart {
	public String rearrangeString(String str, int k) {
		if (k <= 1) {
            return str;
        }
        int[] dict = new int[26];
        
        for (int i = 0; i < str.length(); i++) {
            dict[str.charAt(i) - 'a']++;
        }
        
        PriorityQueue<Letter> queue = new PriorityQueue<Letter> (26, new Comparator<Letter> () {
            public int compare (Letter l1, Letter l2) {
            	if (l1.times == l2.times) {
            		return Character.compare(l1.c, l2.c);
            	}
                return -Integer.compare(l1.times, l2.times);
            }   
        });
        for (int i = 0; i < dict.length; i++) {
            if (dict[i] > 0) {
            	Letter l = new Letter(dict[i], (char) ('a' + i));
                queue.offer(l);
            }
        }
        
        StringBuilder res = new StringBuilder();
        int n = str.length();
        while (n > 0) {
            int m = Math.min(n, k);
            if (queue.size() < m) {
                return "";
            }
            n -= m;
            ArrayList<Letter> list = new ArrayList<Letter> ();
            for (int i = 0; i < m; i++) {
                Letter l = queue.poll();
                res.append(l.c);
                l.times -= 1;
                if (l.times > 0) {
                    list.add(l);
                }
            }
            
            for (int i = 0; i < list.size(); i++) {
                queue.offer(list.get(i));
            }
        }
        
        return res.toString();
    }
    
    public class Letter {
        int times;
        char c;
        public Letter(int times, char c) {
            this.times = times;
            this.c = c;
        }
    }
    
    public static void main(String[] args) {
    	Rearrange_String_k_Distance_Apart tmp = new Rearrange_String_k_Distance_Apart();
    	String str = "abb";
    	int k = 2;
    	System.out.println(tmp.rearrangeString(str, k));
    }
}
