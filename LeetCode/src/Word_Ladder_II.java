import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode
 * 126. Word Ladder II
 * @author lorreina
 *
 */
public class Word_Ladder_II {
	int len;
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        HashMap<String, List<List<String>>> map = new HashMap<String, List<List<String>>> ();
        List<List<String>> res = new ArrayList<> ();
        HashSet<String> isVisit = new HashSet<String> ();
        
        isVisit.add(beginWord);
      
        List<String> beginlist = new ArrayList<String> ();
        beginlist.add(beginWord);
        List<List<String>> list = new ArrayList<> ();
        list.add(beginlist);
        map.put(beginWord, list);
        HashSet<String> beginSet = new HashSet<String> ();
        beginSet.add(beginWord);
        len = Integer.MAX_VALUE;
        helper(map, res, beginSet, endWord, wordList, isVisit);
        
        return res;
    }
	
	private void helper(HashMap<String, List<List<String>>> map,
						List<List<String>> res, 
						HashSet<String> beginSet,
						String endWord,
						Set<String> wordList,
						HashSet<String> isVisit) {
		
		HashSet<String> tmp = new HashSet<String> ();
		for (String beginWord : beginSet) {
			char[] ch = beginWord.toCharArray();
			List<List<String>> allBeginList = map.get(beginWord);
	        
	        if (allBeginList.get(0).size() >= len) {
	        	return;
	        }
	        
	        for (int i = 0; i < ch.length; i++) {
	            char old = ch[i];
	            for (char c = 'a'; c <= 'z'; c++) {
	                ch[i] = c;
	                String newWord = String.valueOf(ch);
	                
	                if (newWord.equals(endWord)) {
	                	for (int j = 0; j < allBeginList.size(); j++) {
	                		List<String> list = new ArrayList<String> ();
		                    list.addAll(allBeginList.get(j));
		                    list.add(endWord);
		                    res.add(list);
		                    if (len == Integer.MAX_VALUE) {
		                    	len = list.size();
		                    }
	                	}
	                } else if (wordList.contains(newWord) && !isVisit.contains(newWord)) {
	                	tmp.add(newWord);
	                	List<List<String>> newAllBeginList = new ArrayList<> ();
	                	if (map.containsKey(newWord)) {
	                		newAllBeginList = map.get(newWord);
	                	} 
	                	
	                	for (int j = 0; j < allBeginList.size(); j++) {
	                		List<String> list = new ArrayList<String> ();
		                	list.addAll(allBeginList.get(j));
		                	list.add(newWord);
		                	newAllBeginList.add(list);
	                	}
	                	map.put(newWord, newAllBeginList);
	                }
	            }
	            ch[i] = old;
	        }
		}

		
		if (len != Integer.MAX_VALUE || tmp == null || tmp.size() == 0) {
			return;
		} else {
			for (String s : tmp) {
				isVisit.add(s);
			}
			helper(map, res, tmp, endWord, wordList, isVisit);
		}
	}
	
	public static void main(String[] args) {
		Word_Ladder_II tmp = new Word_Ladder_II();
		String beginWord = "red";
		String endWord = "tax";
		Set<String> wordList = new HashSet<String> ();
		String[] wordlist = {"ted","tex","red","tax","tad","den","rex","pee"};
		for (int i = 0; i < wordlist.length; i++) {
			wordList.add(wordlist[i]);
		}
		
		List<List<String>> res = tmp.findLadders(beginWord, endWord, wordList);
		
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j));
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
