import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode
 * 140. Word Break II
 * @author lorreina
 *
 */
public class Word_Break_II {
	// Solution 2:
	// Backtracking with memorization
	private HashMap<String, List<String>> map;
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return new ArrayList<String> ();
        }
        
        map = new HashMap<String, List<String>> ();
        
        return helper(s, wordDict);
    }
    
    private List<String> helper(String s, Set<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        List<String> res = new ArrayList<String> ();
        if (wordDict.contains(s)) {
            res.add(s);
        }
        
        // Break from "a"-"bcd" to "abc"-"d"
        // ["a"+"bcd", "ab"+"cd", "abc"+"d"]
        for (int i = 1; i < s.length(); i++) { 
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (wordDict.contains(right)) {
                // found a valid break
                List<String> breaks = helper(left, wordDict);
                for (String w : breaks) {
                    res.add(w + " " + right);
                }
            }
        }
        
        // add breakable result of string s to map
        map.put(s, res);
        
        return res;
    }
	
	
	
	// Solution 1:
	// This backtracking solution got TLE now
	/*
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String> ();
        
        if (s == null || wordDict == null) {
            return res;
        }
        
        // dp[i] represents if s.substring(0, i) is word-breakable.
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        // dps.get(i) means the mutiple word-break results of s.substring(0, i);
        ArrayList<ArrayList<String>> dps = new ArrayList<ArrayList<String>> (dp.length);
        for (int i = 0; i < dp.length; i++) {
        	dps.add(new ArrayList<String> ());
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (dp[j] && wordDict.contains(word)) {
                    dp[i] = true;
                    if (dps.get(j) == null || dps.get(j).size() == 0) {
                    	dps.get(i).add(word);
                    } else {
                    	for (int k = 0; k < dps.get(j).size(); k++) {
                        	String sentence = dps.get(j).get(k) + " " + word;
                        	dps.get(i).add(sentence);
                        }
                    }
                    
                }
            }
        }
        
        return dps.get(dp.length - 1);
    }
    */
	
    public static void main(String[] args) {
    	Word_Break_II tmp = new Word_Break_II();
    	Set<String> set = new HashSet<String>();
    	set.add("cat");
    	set.add("cats");
    	set.add("and");
    	set.add("sand");
    	set.add("dog");
    	
    	List<String> list = tmp.wordBreak("catsanddog", set);
    	
    	for (int i = 0 ; i < list.size(); i++) {
    		System.out.println(list.get(i));
    	}
//    	System.out.println(wordBreak("catsanddog", set));
    }
}
