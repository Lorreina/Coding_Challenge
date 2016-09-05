import java.util.ArrayList;
import java.util.HashMap;

/**
 * LeetCode
 * 244. Shortest Word Distance II
 * @author lorreina
 *
 */
public class Shortest_Word_Distance_II {
	public class WordDistance {
	    HashMap<String, ArrayList<Integer>> map;
	    
	    public WordDistance(String[] words) {
	        map = new HashMap<String, ArrayList<Integer>> ();
	        for (int i = 0; i < words.length; i++) {
	            if (map.containsKey(words[i])) {
	                map.get(words[i]).add(i);
	            } else {
	                ArrayList<Integer> list = new ArrayList<Integer> ();
	                list.add(i);
	                map.put(words[i], list);
	            }
	        }
	    }

	    public int shortest(String word1, String word2) {
	        int distance = Integer.MAX_VALUE;
	        ArrayList<Integer> index1 = map.get(word1);
	        ArrayList<Integer> index2 = map.get(word2);
	        
	        int i = 0, j = 0;
	        while (i < index1.size() && j < index2.size()) {
	            int pointer1 = index1.get(i);
	            int pointer2 = index2.get(j);
	            int dis = Math.abs(pointer1 - pointer2);
	            if (dis == 1) {
	                return 1;
	            }
	            distance = Math.min(dis, distance);
	            if (pointer1 > pointer2) {
	                j++;
	            } else {
	                i++;
	            }
	        }
	        
	        return distance;
	    }
	}

	// Your WordDistance object will be instantiated and called as such:
	// WordDistance wordDistance = new WordDistance(words);
	// wordDistance.shortest("word1", "word2");
	// wordDistance.shortest("anotherWord1", "anotherWord2");
}
