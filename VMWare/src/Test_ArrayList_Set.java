import java.util.ArrayList;
import java.util.HashSet;

public class Test_ArrayList_Set {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer> ();
		ArrayList<Integer> list2 = new ArrayList<Integer> ();
		ArrayList<Integer> list3 = new ArrayList<Integer> ();
		for (int i = 0; i < 3; i++) {
			list1.add(i);
			list2.add(i);
		}
		list3.add(2);
		list3.add(1);
		list3.add(3);
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>> ();
		set.add(list1);
		set.add(list3);
		System.out.println(set.size());
	}
}
