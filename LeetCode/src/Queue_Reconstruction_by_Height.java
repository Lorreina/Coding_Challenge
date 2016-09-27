import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * LeetCode
 * 406. Queue Reconstruction by Height
 * @author lorreina
 *
 */
public class Queue_Reconstruction_by_Height {
	public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 1) {
            return people;
        }
        
        Arrays.sort(people, new Comparator<int[]> () {
           public int compare(int[] p1, int[] p2) {
               if (p1[0] == p2[0]) {
                   return Integer.compare(p1[1], p2[1]);
               } else {
                   return -Integer.compare(p1[0], p2[0]);
               }
           } 
        });
        
        ArrayList<int[]> list = new ArrayList<int[]> ();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }
        
        return list.toArray(new int[people.length][2]);
    }
}
