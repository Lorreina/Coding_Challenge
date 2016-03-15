
	import java.io.*;
	import java.util.*;

	public class MyHashtable_new<K, V> {
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
		private static final int DEFAULT_CAPACITY = 5000;
		/**
	     * the default load factor.
	     */
		private static final int DEFAULT_LOAD_FACTOR = 2;
		/**
	     * start index for deciding prime number.
	     */
	    private static final int START_INDEX = 3;
	    
	    
	    public static void main(String args[]) throws Exception {
	        new TestHarness(new MyHashtable_new<String, String>()).run();
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
			
			if (tableCount == hashArray.size() * DEFAULT_LOAD_FACTOR) {
				rehash();
			}
			
			int hashValue = hashFunc(key);
			
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

	    /**
		 * get method of the HashTable.
		 * @param key the key.
		 * @return the value regards to the key.
		 */
	    public V get(K key) {
	        // TODO implement
	        int hashValue = hashFunc(key);
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
	     * the constructor without initial capacity.
	     */
		public MyHashtable_new() {
			tableCount = 0;
			hashArray = new ArrayList<LinkedList<DataItem>> (DEFAULT_CAPACITY);
			for (int i = 0; i <DEFAULT_CAPACITY; i++) {
				hashArray.add(new LinkedList<DataItem> ());
			}
		}
	    
	    /**
		 * The function to generate a hashValue for each key.
		 * @param key the key value.
		 * @return hashValue the hashValue for each key.
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
	        //int newTableLength= hashArray.size() * 2;
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

	    /**
	     * A helper class that tests MyHashtable by feeding it puts and gets from STDIN.
	     */
	    public static class TestHarness implements Runnable {
	        final MyHashtable_new<String, String> hashtable;

	        public TestHarness(MyHashtable_new<String, String> hashtable) {
	            this.hashtable = hashtable;
	        }

	        public void run() {
	            Scanner scanner = new Scanner(System.in);
	            while (scanner.hasNext()) {
	                String k = scanner.next();
	                String v = null;
	                if (k.contains("=")) {
	                    String[] split = k.split("\\=");
	                    k = split[0];
	                    v = split[1];
	                }
	                if (v == null) {
	                    System.out.println(hashtable.get(k));
	                } else {
	                    hashtable.put(k, v);
	                }
	            }
	        }
	    }
	}

