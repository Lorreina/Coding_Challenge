import java.util.ArrayList;
import java.util.HashMap;

public class Boss_Employee {
	public static void printRelation(String[] boss, String[] employee) {
		if (boss == null || boss.length == 0) {
			return;
		}
		
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>> ();
		String bigBoss = "";
		
		// read data into hash map
		for (int i = 0; i < boss.length; i++) {
			if (boss[i].equals(employee[i])) {
				bigBoss = boss[i];
			} else {
				if (map.containsKey(boss[i])) {
					map.get(boss[i]).add(employee[i]);
				} else {
					ArrayList<String> list = new ArrayList<String> ();
					list.add(employee[i]);
					map.put(boss[i], list);
				}
			}
		}
		
		printName(map, bigBoss, 0);
	}
	
	private static void printName(HashMap<String, ArrayList<String>> map, String name, int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("  ");
		}
		System.out.println(name);
		if (!map.containsKey(name)) {
			return;
		} else {
			ArrayList<String> list = map.get(name);
			for (int i = 0; i < list.size(); i++) {
				printName(map, list.get(i), level + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		String[] boss = {"parker", "parker", "laks", "avinash", "laks", "parker", "david"};
		String[] employee = {"parker", "laks", "avinash", "jonathan", "jason", "david", "arisa"};
		printRelation(boss, employee);
	}
}

