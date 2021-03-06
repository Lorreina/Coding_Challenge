import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode
 * 347. Top K Frequent Elements
 * @author lorreina
 *
 */
public class Top_K_Frequent_Elements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] freq = new List[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        for (int key : map.keySet()) {
            int freqency = map.get(key);
            if (freq[freqency] == null) {
                List<Integer> list = new ArrayList<Integer> ();
                list.add(key);
                freq[freqency] = list;
            } else {
                freq[freqency].add(key);
            }
        }
        
        // int sum = 0;
        List<Integer> res = new ArrayList<Integer> ();
        for (int i = freq.length - 1; i >= 0; i--) {
            if (freq[i] != null) {
                res.addAll(freq[i]);
                // sum += i * freq[i].size();
                if (res.size() >= k) {
                    break;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,1,1,2,2,3};
    	int k = 2;
    	
    	Top_K_Frequent_Elements tmp = new Top_K_Frequent_Elements();
    	List<Integer> res = tmp.topKFrequent(nums, k);
    	
    	for (int i = 0; i < res.size(); i++) {
    		System.out.print(res.get(i));
    		System.out.print(" ");
    	}
    }
}
