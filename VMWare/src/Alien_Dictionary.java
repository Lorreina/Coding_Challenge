import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode
 * 269. Alien Dictionary
 * @author lorreina
 *
 */
public class Alien_Dictionary {
	public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
            
        }
        
        int[][] map = new int[26][26];
        int[] indegree = new int[26];
        boolean[] used = new boolean[26];
        
        // add first word to used array
        for (int i = 0; i < words[0].length(); i++) {
            used[words[0].charAt(i) - 'a'] = true;
        }
        
        for (int i = 1; i < words.length; i++) {
            buildMap(map, indegree, words[i - 1], words[i]);
            for (int j = 0; j < words[i].length(); j++) {
                used[words[i].charAt(j) - 'a'] = true;
            }
        }
        
        Queue<Integer> queue = new ArrayDeque<Integer> ();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0 && used[i] == true) {
                queue.add(i);
            }
        }
        
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            int index = queue.poll();
            used[index] = false;
            res.append((char) ('a' + index));
            for (int i = 0; i < 26; i++) {
                if (map[index][i] == 1) {
                    indegree[i] -= 1;
                    if (indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] != 0) {
                return "";
            }
        }
        
        return res.toString();
        
    }
    
    private void buildMap(int[][] map, int[] indegree, String word1, String word2) {
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (map[word1.charAt(i) - 'a'][word2.charAt(i) - 'a'] == 0) {
                    map[word1.charAt(i) - 'a'][word2.charAt(i) - 'a'] = 1;
                    indegree[word2.charAt(i) - 'a'] += 1;
                }
                return;
            }
        }
    }
    
    
    public static void main(String[] args) {
    	Alien_Dictionary tmp = new Alien_Dictionary();
    	String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
    	System.out.println(tmp.alienOrder(words));
    }
}
