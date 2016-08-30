/* Enter your code here. Read input from STDIN. Print output to STDOUT */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.IOException;

public class RocketFuel{
	public static class Spaceship {
		int id;
		int startNum;
		long startTime;
		long endTime;
		public int score;
		
		public Spaceship(int id, long startTime, long endTime) {
			this.id = id;
			this.startTime = startTime;
			this.endTime = endTime;
			this.score = 0;
			this.startNum = 0;
		}
		
		
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        ArrayList<Spaceship> spaceship = new ArrayList<Spaceship>();
//        ArrayList<Long> time = new ArrayList<Long> ();
//        Long left = Long.MAX_VALUE;
//        Long right = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
        	line = br.readLine();
        	String[] tmp = line.split(" ");
        	spaceship.add(new Spaceship(Integer.parseInt(tmp[0]), Long.parseLong(tmp[1]), Long.parseLong(tmp[2])));
//        	time.add(Long.parseLong(tmp[1]));
//        	time.add(Long.parseLong(tmp[2]));
//        	left = Math.min(left, Long.parseLong(tmp[1]));
//        	right = Math.max(right, Long.parseLong(tmp[2]));
        }
        
//        SegmentTree tree = new SegmentTree();
//        SegmentTree.STNode root = SegmentTree.constructSegmentTree(time, left, right);
        
//        for (int i = 0; i < spaceship.size(); i++) {
//        	spaceship.get(i).score = SegmentTree.getSum(root, spaceship.get(i).startTime, spaceship.get(i).endTime);
//        }
        
        
        
        Collections.sort(spaceship, new Comparator<Spaceship>() {
			public int compare(Spaceship s1, Spaceship s2) {
				if (s1.startTime < s2.startTime) {
					return -1;
				}
				if (s1.startTime == s2.startTime) {
					if (s1.id < s2.score) {
						return -1;
					} else {
						return 1;
					}
				}
				return 1;
			}
		});
        
        for (int i = 0; i < spaceship.size(); i++) {
        	spaceship.get(i).startNum = i;
        }
        
        Collections.sort(spaceship, new Comparator<Spaceship>() {
			public int compare(Spaceship s1, Spaceship s2) {
				if (s1.endTime < s2.endTime) {
					return -1;
				}
				if (s1.endTime == s2.endTime) {
					if (s1.id < s2.score) {
						return -1;
					} else {
						return 1;
					}
				}
				return 1;
			}
		});
        
        ArrayList<Integer> startNum = new ArrayList<Integer>();
        
        for (int i = 0; i < spaceship.size(); i++) {
        	spaceship.get(i).score = insert(startNum, spaceship.get(i).startNum);
        }
        
        
        // print the output
        for (int i = 0; i < spaceship.size(); i++) {
        	System.out.println(spaceship.get(i).id + " " + spaceship.get(i).score);
        }
        
    }
    
    private static int insert(ArrayList<Integer> startNum, int target) {
		// TODO Auto-generated method stub
    	int index = search(startNum, target);
    	if (index < 0) {
    		index = 1;
    	}
    	int score = startNum.size() - index;
    	startNum.add(score);
		return score;
	}

	private static int search(ArrayList<Integer> startNum, int target) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static class SegmentTree {
        public static class STNode {
            long leftIndex;
            long rightIndex;
            int sum;
            STNode leftNode;
            STNode rightNode;
        }

        static STNode constructSegmentTree(ArrayList<Long> time, long l, long r) {
            if (l == r) {
                STNode node = new STNode();
                node.leftIndex = l;
                node.rightIndex = r;
                node.sum = 1;
                return node;
            }
            long mid = (l + r) / 2;
            STNode leftNode = constructSegmentTree(time, l, mid);
            STNode rightNode = constructSegmentTree(time, mid+1, r);
            STNode root = new STNode();
            root.leftIndex = leftNode.leftIndex;
            root.rightIndex = rightNode.rightIndex;
            root.sum = leftNode.sum + rightNode.sum;
            root.leftNode = leftNode;
            root.rightNode = rightNode;
            return root;
        }

        static int getSum(STNode root, long l, long r) {
            if (root.leftIndex >= l && root.rightIndex <= r) {
                return root.sum;
            }
            if (root.rightIndex < l || root.leftIndex > r) {
                return 0;
            }
            return getSum(root.leftNode, l, r) + getSum(root.rightNode, l, r);
        }
    }
}
