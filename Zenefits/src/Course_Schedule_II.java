import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

/**
 * LeetCode
 * 210. Course Schedule II
 * @author lorreina
 *
 */

public class Course_Schedule_II {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap <Integer, ArrayList<Integer>> ();
        int[] indegree = new int[numCourses];
        
        ArrayList<Integer> tmp = new ArrayList<Integer> ();
        for (int i = 0; i < prerequisites.length; i++) {
            int preCourse = prerequisites[i][1];
            int course = prerequisites[i][0];
            if (map.containsKey(preCourse)) {
                tmp = map.get(preCourse);
                tmp.add(course);
                indegree[course]++;
            } else {
            	ArrayList<Integer> list = new ArrayList<Integer> ();
            	list.add(course);
                map.put(preCourse, list);
                indegree[course]++;
            }
        }
        
        Queue<Integer> queue = new ArrayDeque<Integer> ();
        for (int i = 0; i < numCourses; i++) {
        	if (indegree[i] == 0) {
        		queue.offer(i);
        	}
        }
        
        int count = 0;
        int[] result = new int[numCourses];
        
        while(!queue.isEmpty()) {
        	int vertex = queue.poll();
        	result[count] = vertex;
        	count++;
        	if (map.containsKey(vertex)) {
        		tmp = map.get(vertex);
        		for (int i : tmp) {
        			indegree[i]--;
        			if (indegree[i] == 0) {
        				queue.offer(i);
        			}
        		}
        	}
        }
        if (count == numCourses) {
        	return result;
        }
        return new int[0];
    }
}
