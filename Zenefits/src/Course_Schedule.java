import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class Course_Schedule {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while(!queue.isEmpty()) {
        	int vertex = queue.poll();
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
        	return true;
        }
        return false;
    }

	public static void main(String[] args) {
		int[][] prerequisites = {{0,1}, {0,2}, {1,2}};
		System.out.println(canFinish(3, prerequisites));
	}
}
