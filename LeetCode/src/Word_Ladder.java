import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode
 * 127. Word Ladder
 * @author lorreina
 *
 */
public class Word_Ladder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String> ();
        Set<String> endSet = new HashSet<String> ();
        Set<String> visited = new HashSet<String> ();
        int len = 1;
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            Set<String> tmp = new HashSet<String> ();
            
            // swap beginSet and endSet if necessary.
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = new HashSet<String> ();
                temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        String newWord = String.valueOf(chs);
                        if (endSet.contains(newWord)) {
                            return len + 1;
                        }
                        
                        if (wordList.contains(newWord) && !visited.contains(newWord)) {
                            tmp.add(newWord);
                            visited.add(newWord);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = tmp;
            len++;
        }
        
        return 0;
    }
}
