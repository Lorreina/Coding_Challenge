import java.util.ArrayList;

public class Distance_Between_Character {
	public static int findDistance(String s, char x, char y) {
		if (s == null) {
			return -1;
		}
		
		if (x == y) {
			return 0;
		}
		
		ArrayList<Integer> locationX = new ArrayList<Integer> ();
		ArrayList<Integer> locationY = new ArrayList<Integer> ();
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == x) {
				locationX.add(i);
			} else if (s.charAt(i) == y) {
				locationY.add(i);
			}
		}
		
		if (locationX.isEmpty() || locationY.isEmpty()) {
			return -1;
		}
		
		int dis = Integer.MAX_VALUE;
		int i = 0, j = 0;
		while (i < locationX.size() && j < locationY.size()) {
			dis = Math.min(Math.abs(locationX.get(i) - locationY.get(j)), dis);
			if (locationX.get(i) < locationY.get(j)) {
				i++;
			} else {
				j++;
			}
		}
		
		return dis;
	}
	
	public static void main(String[] args) {
		System.out.println(findDistance("abcdea", 'a', 'd'));
	}
}
