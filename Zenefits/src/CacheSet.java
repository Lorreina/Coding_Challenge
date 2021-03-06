import java.util.HashSet;

public class CacheSet {
	private static CacheSet instance = null;
	private static HashSet<Integer> set;
	public static CacheSet getInstance() {
		if (instance == null) {
			synchronized(CacheSet.class) {
				if (instance == null) {
					instance = new CacheSet();
				}
			}
		}
		return instance;
	}
	
	private CacheSet() {
		set = new HashSet<Integer> ();
	}
	
	public void add(int x) {
		set.add(x);
	}
	
	public boolean search(int x) {
		if (set.contains(x)) {
			return true;
		}
		return false;
	}
	
	public void delete(int x) {
		if (search(x)) {
			set.remove(x);
		}
	}
	
	public void deleteAll() {
		synchronized(CacheSet.class) {
			instance = new CacheSet();
		}
	}
}
