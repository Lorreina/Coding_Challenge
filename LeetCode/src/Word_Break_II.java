import java.util.ArrayList;
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
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String> ();
        
        if (s == null || wordDict == null) {
            return res;
        }
        
        // dp[i] represents if s.substring(0, i) is word-breakable.
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
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
	
    public static void main(String[] args) {
    	Set<String> set = new HashSet<String>();
    	set.add("cat");
    	set.add("cats");
    	set.add("and");
    	set.add("sand");
    	set.add("dog");
    	
    	List<String> list = wordBreak("catsanddog", set);
    	
    	for (int i = 0 ; i < list.size(); i++) {
    		System.out.println(list.get(i));
    	}
//    	System.out.println(wordBreak("catsanddog", set));
    	
    }
}