import java.util.Stack;

/**
 * LeetCode
 * 316. Remove Duplicate Letters
 * @author lorreina
 *
 */
public class Remove_Duplicate_Letters {
	public String removeDuplicateLetters(String s) {
        int[] dict = new int[26];
        Stack<Integer> stack = new Stack<Integer> ();
        boolean[] visited = new boolean[26];
        
        char[] ch = s.toCharArray();
        
        for (char c : ch) {
            dict[c - 'a']++;
        }
        
        for (char c : ch) {
            int index = c - 'a';
            dict[index]--;
            
            if (visited[index]) {
                continue;
            }
            
            while (!stack.isEmpty() && index < stack.peek() && dict[stack.peek()] > 0) {
                visited[stack.pop()] = false;
            }
            
            stack.push(index);
            visited[index] = true;
        }
        
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, (char) ('a' + stack.pop()));
        }
        
        return res.toString();
    }
}
