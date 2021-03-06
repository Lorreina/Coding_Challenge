


/**
 * LRU cache using HashMap and TreeMap.
 * 

import java.util.HashMap;
import java.util.TreeMap;

public class LRUCache {
    public int index;
    public int count;
    public HashMap<Integer, Integer> cache;
    public HashMap<Integer, Integer> order;
    public TreeMap<Integer, Integer> orderSort;
    public int capacity;
    
    public LRUCache(int capacity) {
        this.index = 0;
        this.count = 0;
        this.cache = new HashMap<Integer, Integer> ();
        this.order = new HashMap<Integer, Integer> ();
        this.orderSort = new TreeMap<Integer, Integer> ();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            index++;
            int result = cache.get(key);
            int thisOrder = order.get(key);
            order.put(key, index);
            orderSort.remove(thisOrder);
            orderSort.put(index, key);
            return result;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        index++;
        if (cache.containsKey(key)) {
            cache.put(key, value);
            int thisOrder = order.get(key);
            order.put(key, index);
            orderSort.remove(thisOrder);
            orderSort.put(index, key);
        } else {
            if (count < capacity) {
                cache.put(key, value);
                order.put(key, index);
                orderSort.put(index, key);
                count++;
            } else {
                int thisOrder = orderSort.firstKey();
                int thisKey = orderSort.get(thisOrder);
                orderSort.remove(thisOrder);
                orderSort.put(index, key);
                order.remove(thisKey);
                order.put(key, index);
                cache.remove(thisKey);
                cache.put(key, value);
            }
        }
    }
}

**/


