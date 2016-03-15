import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*
 *  Requirements: implement public void put(K key, V value); public V get(K key);
 * 	WePay online coding challenge.
 */
public class MyHashTable<K, V> {
	/**
	 * the array of HashTable.
	 */
	private ArrayList<LinkedList<DataItem>> hashArray;
	/**
	 * the number of items in the hashArray.
	 */
	private long tableCount;
	/**
     * the default capacity.
     */
	private static final int DEFAULT_CAPACITY = 3;
	/**
     * the default load factor.
     */
	private static final double DEFAULT_LOAD_FACTOR = 0.5;
	/**
     * start index for deciding prime number.
     */
    private static final int START_INDEX = 3;
	
    /**
     * the constructor without initial capacity.
     */
	public MyHashTable() {
		tableCount = 0;
		hashArray = new ArrayList<LinkedList<DataItem>> (DEFAULT_CAPACITY);
		for (int i = 0; i <DEFAULT_CAPACITY; i++) {
			hashArray.add(new LinkedList<DataItem> ());
		}
	}
	/**
	 * The function to generate a hashValue for each key.
	 * @param key
	 * @return hashValue
	 */
	private int hashFunc(K key) {
		int index = (key.hashCode() & 0x7fffffff) % hashArray.size();
		return index;
	}
	
	/**
     * doubles array length (using prime number) and rehash items whenever the load factor is reached.
     */
	private void rehash() {
		int newTableLength = findPrime(hashArray.size());
		ArrayList<LinkedList<DataItem>> hashArrayCopy = new ArrayList<LinkedList<DataItem>> (hashArray);
		hashArray = new ArrayList<LinkedList<DataItem>> (newTableLength);
		for (int i = 0; i < newTableLength; i++) {
			hashArray.add(new LinkedList<DataItem> ());
		}
		tableCount = 0;
		for (int i = 0; i < hashArrayCopy.size(); i++) {
			Iterator itr = hashArrayCopy.get(i).iterator();
			if (itr.hasNext()) {
				DataItem data = (DataItem) itr.next();
				this.put((K)data.getKey(), (V)data.getValue());
			}
		}
	}

	/**
     * Inserts a new DataItem(key, value) to the HashTable.
     * @param key the key.
     * @param value the value.
     */
	public void put(K key, V value) {
		if (key == null || value == null) {
			return;
		}
		
		if ((double) (tableCount + 1) / hashArray.size() > DEFAULT_LOAD_FACTOR) {
			rehash();
		}
		
		int hashValue = hashFunc(key);
		
		if (hashArray.get(hashValue) == null) {
			LinkedList<DataItem> list = new LinkedList<DataItem> ();
			list.add(new DataItem<K, V> (key, value));
			hashArray.set(hashValue, list);
		} else {
			Iterator itr = hashArray.get(hashValue).iterator();
			while (itr.hasNext()) {
				DataItem data = (DataItem) itr.next();
				if (data.getKey().equals(key)) {
					data.setValue(value);
					return;
				}
			}
			if (!itr.hasNext()) {
				hashArray.get(hashValue).addLast(new DataItem<K, V>(key, value));
				tableCount++;
			}
		}
		
	}
	
	/**
	 * get method of the HashTable.
	 * @param key the key.
	 * @return the value regards to the key.
	 */
	public V get(K key) {
		// TODO Auto-generated method stub
		int hashValue = hashFunc(key);
		if (hashArray.get(hashValue) == null) {
			return null;
		}
		Iterator itr = hashArray.get(hashValue).iterator();
		while (itr.hasNext()) {
			DataItem data = (DataItem) itr.next();
			if (data.getKey().equals(key)) {
				return (V) data.getValue();
			}
		}
		return null;
	}

	/**
     * helper function to find the first prime number that is greater than 2 * tableLength.
     * @param tableLength the length of original hashArray.
     * @return the first prime number that is great than 2 * tableLength.
     */
	private int findPrime(int tableLength) {
		int n = tableLength * 2;
		while (true) {
			if (isPrime(n)) {
				return n;
			} else {
				n++;
			}
		}
	}

	/**
     * Helper function to check whether n is a prime number.
     * @param n the number.
     * @return true if n is a prime number.
     */
	private boolean isPrime(int n) {
		if (n < 1) {
			return false;
		}
		if (n % 2 == 0 && n != 2) {
			return false;
		}
		for (int i = START_INDEX; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
     * private static data item nested class.
     */
	private static class DataItem<K, V> {
		/** 
		 * the key value.
		 */
		private K key;
		/**
		 * the value.
		 */
		private V value;
		
		/**
         * instructor of DataItem class.
         * @param value the string value.
         * @param frequency the frequency of string.
         */
		DataItem(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		/**
		 * the get method of key.
		 * @return the key.
		 */
		public K getKey() {
			return this.key;
		}
		
		/**
		 * the get method for value.
		 * @return the value.
		 */
		public V getValue() {
			return this.value;
		}
		
		/**
		 * set the value.
		 * @param value the value.
		 */
		public void setValue(V value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		MyHashTable<Integer, String> table = new MyHashTable<Integer, String> ();
		table.put(0, "wddwxy");
		table.put(1, "is");
		table.put(999, "doggy");
		table.put(999, "debby");
		table.put(2, "2");
		table.put(3, "3");
		System.out.println(table.get(999));
		System.out.println(table.get(888));
		System.out.println(table.get(3));
	}
}
