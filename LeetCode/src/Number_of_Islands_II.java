import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode
 * 305.  Number of Islands II
 * @author lorreina
 *
 */
public class Number_of_Islands_II {
	
	// Solution 2:
	
	int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
	    List<Integer> result = new ArrayList<>();
	    if(m <= 0 || n <= 0) return result;

	    int count = 0;                      // number of islands
	    int[] roots = new int[m * n];       // one island = one tree
	    Arrays.fill(roots, -1);            

	    for(int[] p : positions) {
	        int root = n * p[0] + p[1];     // assume new point is isolated island
	        roots[root] = root;             // add new island
	        count++;

	        for(int[] dir : dirs) {
	            int x = p[0] + dir[0]; 
	            int y = p[1] + dir[1];
	            int nb = n * x + y;
	            if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) continue;
	            
	            int rootNb = findIsland(roots, nb);
	            if(root != rootNb) {        // if neighbor is in another island
	                roots[root] = rootNb;   // union two islands 
	                root = rootNb;          // current tree root = joined tree root
	                count--;               
	            }
	        }

	        result.add(count);
	    }
	    return result;
	}

	public int findIsland(int[] roots, int id) {
	    while(id != roots[id]) {
	    	roots[id] = roots[roots[id]];   // only one line added
	        id = roots[id];
	    }
	    return id;
	}
	
	// Solution 1: TLE
	/*
	HashMap<ArrayList<Integer>, Integer> groupMap;
    HashMap<Integer, ArrayList<ArrayList<Integer>>> map;
    int m;
    int n;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer> ();
        if (positions == null || positions.length == 0 || positions[0].length == 0) {
            return res;
        }
        
        groupMap = new HashMap<ArrayList<Integer>, Integer> ();
        map = new HashMap<Integer, ArrayList<ArrayList<Integer>>> ();
        this.m = m;
        this.n = n;
        
        for (int i = 0; i < positions.length; i++) {
            add(positions[i], i);
            res.add(map.size());
        }
        
        return res;
    }
    
    private void add(int[] pos, int key) {
        if (groupMap.containsKey(pos)) {
            return;
        }
        
        map.put(key, new ArrayList<ArrayList<Integer>> ());
        ArrayList<Integer> posList = new ArrayList<Integer> ();
        posList.add(pos[0]);
        posList.add(pos[1]);
        map.get(key).add(posList);
        groupMap.put(posList, key);
        
        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> posListNew = new ArrayList<Integer> ();
            posListNew.add(pos[0] + dx[i]);
            posListNew.add(pos[1] + dy[i]);
            if (groupMap.containsKey(posListNew)) {
                int oldKey = groupMap.get(posListNew);
                if (oldKey < key) {
                    update(oldKey, key);
                }
            }
        }
        
        return;
    }
    
    private void update(int oldKey, int key) {
        // update groupMap
        for (ArrayList<Integer> pos : map.get(oldKey)) {
            groupMap.put(pos, key);
        }
        
        // update map
        map.get(key).addAll(map.get(oldKey));
        map.remove(oldKey);
        
        return;
    }
    */
	
    
    public static void main(String[] args) {
    	Number_of_Islands_II tmp = new Number_of_Islands_II();
    	int m = 3;
    	int n = 3;
//    	int[][] positions = {{0,0},{0,1},{1,2},{2,1}};
    	int[][] positions = {{0,2}, {1,1}, {1,2}, {0,0}, {0,1}};
    	List<Integer> res = tmp.numIslands2(m, n, positions);
    	for (int i = 0; i < res.size(); i++) {
    		System.out.print(res.get(i));
    		System.out.print(" ");
    	}
    	
//    	HashMap<ArrayList<Integer>, Integer> map = new HashMap<ArrayList<Integer>, Integer>();
//    	ArrayList<Integer> a = new ArrayList<Integer> ();
//    	ArrayList<Integer> b = new ArrayList<Integer> ();
//    	a.add(1);
//    	b.add(1);
//    	a.add(1);
//    	b.add(1);
//    	map.put(a, 1);
//    	System.out.println(map.containsKey(b));
    }
}
