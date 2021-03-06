import java.util.ArrayList;

/**
 * LeetCode
 * 245. Shortest Word Distance III
 * @author lorreina
 *
 */
public class Shortest_Word_Distance_III {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            return helperSame(words, word1);
        } else {
            return helperNotSame(words, word1, word2);
        }
    }
    
    private int helperSame(String[] words, String word) {
        int distance = Integer.MAX_VALUE;
        ArrayList<Integer> index = new ArrayList<Integer> ();
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                index.add(i);
            }
        }
        
        for (int i = 1; i < index.size(); i++) {
            distance = Math.min(distance, index.get(i) - index.get(i - 1));
            if (distance == 1) {
                return distance;
            }
        }
        
        return distance;
    }
    
    private int helperNotSame(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        ArrayList<Integer> index1 = new ArrayList<Integer> ();
        ArrayList<Integer> index2 = new ArrayList<Integer> ();
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1.add(i);
            } else if (words[i].equals(word2)) {
                index2.add(i);
            }
        }
        
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
