import java.util.ArrayList;

/**
 * LeetCode
 * 243. Shortest Word Distance
 * @author lorreina
 *
 */
public class Shortest_Word_Distance {
    public int shortestDistance(String[] words, String word1, String word2) {
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
