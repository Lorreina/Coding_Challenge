import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Valid_Special_Binary_Tree {
	static HashMap<Character, ArrayList<Character>> map;
	static ArrayList<Character> root = new ArrayList<Character> ();
	static HashSet<Character> all;
	static HashSet<Character> children;
	static StringBuilder str;
	static HashSet<Character> parent = new HashSet<Character> ();
	static boolean hasCycle = false;
	
	
	public static int readData(ArrayList<ArrayList<Character>> input) {
		if (input == null || input.size() == 0) {
			System.out.println("input is blank! Please try again.");
			return -1;
		}
		
		map = new HashMap<Character, ArrayList<Character>> ();
		HashSet<Character> parent = new HashSet<Character> ();
		all = new HashSet<Character> ();
		children = new HashSet<Character> ();
		boolean hasDup = false;
		
		for (int i = 0; i < input.size(); i++) {
			if (children.contains(input.get(i).get(0))) {
				hasCycle = true;
			}
			if (map.containsKey(input.get(i).get(0))) {
				ArrayList<Character> tmp = map.get(input.get(i).get(0));
				if (tmp.size() == 2) {
					System.out.println("Error: E1!");
					return -1;
				} else {
					if (tmp.get(0) == input.get(i).get(1)) {
						hasDup = true;
					}
					tmp.add(input.get(i).get(1));
					
				}
			} else {
				ArrayList<Character> tmp = new ArrayList<Character> ();
				tmp.add(input.get(i).get(1));
				map.put(input.get(i).get(0), tmp);
			}
			
			parent.add(input.get(i).get(0));
			children.add(input.get(i).get(1));
			all.add(input.get(i).get(0));
			all.add(input.get(i).get(1));
		}
		
		if (hasDup == true) {
			System.out.println("Error: E2!");
			return -1;
		}
		
		if (hasCycle == true) {
			System.out.println("Error: E3!");
			return -1;
		}
//		
//		if (all.size() - children.size() > 1) {
//			System.out.println("Error: E4!");
//			return -1;
//		}
		
		
		
		return 1;
	}
	
	public static void buildTree(char c) {
		str.append("(");
		str.append(c);
		if (map.containsKey(c)) {
			ArrayList<Character> tmp = map.get(c);
			// find cycle
			for (int i = 0; i < tmp.size(); i++) {
				if (parent.contains(tmp.get(i))) {
					hasCycle = true;
					return;
				}
			}
			if (tmp.size() == 1) {
				buildTree(tmp.get(0));
			} else {
				if (tmp.get(0) < tmp.get(1)) {
					buildTree(tmp.get(0));
					buildTree(tmp.get(1));
				} else {
					buildTree(tmp.get(1));
					buildTree(tmp.get(0));
				}
			}
		}
		str.append(")");
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Character>> input = new ArrayList<ArrayList<Character>> ();
		ArrayList<Character> p1 = new ArrayList<Character> ();
		p1.add('A');
		p1.add('B');
		input.add(p1);
		ArrayList<Character> p2 = new ArrayList<Character> ();
		p2.add('A');
		p2.add('C');
		input.add(p2);
		ArrayList<Character> p3 = new ArrayList<Character> ();
		p3.add('B');
		p3.add('D');
		input.add(p3);
		ArrayList<Character> p4 = new ArrayList<Character> ();
		p4.add('D');
		p4.add('C');
		input.add(p4);
//		ArrayList<Character> p5 = new ArrayList<Character> ();
//		p5.add('E');
//		p5.add('G');
//		input.add(p5);
//		ArrayList<Character> p6 = new ArrayList<Character> ();
//		p6.add('A');
//		p6.add('C');
//		input.add(p6);
//		ArrayList<Character> p7 = new ArrayList<Character> ();
//		p7.add('C');
//		p7.add('E');
//		input.add(p7);
		int flag = readData(input);
		if (flag == 1) {
			// find root
			Iterator itr = all.iterator();
			if (itr.hasNext()) {
				char c = (char) itr.next();
				if (!children.contains(c)) {
					root.add(c);
				}
			}
			str = new StringBuilder();
			for (int i = 0; i < root.size(); i++) {
				buildTree(root.get(i));
			}
			
			if (hasCycle) {
				System.out.println("Error: E3!");
			} else if (root.size() > 1) {
				System.out.println("Error: E4!");
			} else {
				System.out.println(str.toString());
			}
		}
	}
}
//(A(B(D(E(G))))(C(F)))