import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 267. Palindrome Permutation II
 * @author lorreina
 *
 */
public class Palindrome_Permutation_II {
	// Version 2: Rotate + dfs
	public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<String> ();
        if (s == null || s.length() == 0) {
            return res;
        }
        
        int[] dict = new int[256];
        for (char c : s.toCharArray()) {
            dict[c - 'A'] += 1;
        }
        
        char single = '#';
        StringBuilder sb = new StringBuilder();
        // char[] ch = new int[s.length() / 2];
        // int index = 0;
        for (int i = 0; i < dict.length; i++) {
            char c = (char) ('A' + i);
            if (dict[i] % 2 == 1 && single != '#') {
                return res;
            } else if (dict[i] % 2 == 1) {
                single = c;
            }
            
            for (int j = 0; j < dict[i] / 2; j++) {
                sb.append(c);
            }
        }
        
        if (sb.length() == 0) {
            res.add(s);
            return res;
        }
    
        List<StringBuilder> half = helper(sb);
        if (single == '#') {
            for (int i = 0; i < half.size(); i++) {
                res.add(half.get(i).toString() + half.get(i).reverse().toString());
            }
        } else {
            for (int i = 0; i < half.size(); i++) {
                res.add(half.get(i).toString() + single + half.get(i).reverse().toString());
            }
        }
        
        return res;
    }
    
    private List<StringBuilder> helper(StringBuilder sb) {
        List<StringBuilder> list = new ArrayList<StringBuilder> ();
        
        if (sb.length() == 1) {
            list.add(new StringBuilder(sb));
            return list;
        }
        
        char last = '#';
        for (int i = 0; i < sb.length(); i++) {
            char x = sb.charAt(0);
            sb.deleteCharAt(0);
            
            if (i == 0 || x != last) {
                List<StringBuilder> subList = helper(sb);
                for (int j = 0; j < subList.size(); j++) {
                    subList.get(j).insert(0, x);
                    list.add(subList.get(j));
                }
            }
            
            last = x;
            sb.append(x);
        }
        
        return list;
    }
	
	
	// Version 1: dfs
	/*
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<String> ();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        List<StringBuilder> res = new ArrayList<StringBuilder> ();
        int[] ch = new int[256];
        boolean hasMiddle = false;
        String middle = "";
        
        for (char c : s.toCharArray()) {
            ch[(int) c]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] % 2 == 1) {
                if (hasMiddle) {
                    return result;
                } else {
                    hasMiddle = true;
                    middle = String.valueOf((char) i);
                }
                ch[i]--;
            }
            
            for (int j = 0; j < ch[i]; j = j + 2) {
                sb.append((char) i);
            }
        }
        
        char[] half = new char[sb.length()];
        sb.getChars(0, sb.length(), half, 0);
        boolean[] used = new boolean[sb.length()];
        
        dfs(res, new StringBuilder(), used, half);
        
        if (hasMiddle) {
            for (int i = 0; i < res.size(); i++) {
                String permutation = res.get(i).toString() + middle + res.get(i).reverse().toString();
                result.add(permutation);
            }
        } else {
            for (int i = 0; i < res.size(); i++) {
                String permutation = res.get(i).toString() + res.get(i).reverse().toString();
                result.add(permutation);
            }
        }
        
        return result;
    }
    
    private void dfs(List<StringBuilder> res, StringBuilder sb, boolean[] used, char[] half) {
        if (sb.length() == half.length) {
            res.add(new StringBuilder(sb));
            return;
        }
        
        char last = half[0];
        boolean isFirst = true;
        for (int i = 0; i < half.length; i++) {
            if (used[i]) {
                continue;
            }
            
            if (!isFirst && half[i] == last) {
                continue;
            }
            
            isFirst = false;
            last = half[i];
            sb.append(half[i]);
            used[i] = true;
            dfs(res, sb, used, half);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
    */
    
    public static void main(String[] args) {
    	Palindrome_Permutation_II tmp = new Palindrome_Permutation_II();
    	String s = "aabb";
    	List<String> res = tmp.generatePalindromes(s);
    	for (int i = 0; i < res.size(); i++) {
    		System.out.println(res.get(i));
    	}
    }

}
