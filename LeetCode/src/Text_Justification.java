import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 68. Text Justification
 * @author lorreina
 *
 */
public class Text_Justification {
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String> ();
        if (words == null || words.length == 0) {
            res.add("");
            return res;
        }
        
        int sum = words[0].length();
        int start = 0;
        StringBuilder space = new StringBuilder();
        for(int i = 0; i < maxWidth; i++) {
            space.append(" ");
        }
        
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() + sum + 1 > maxWidth) {
                if (start == i - 1) {
                    String line = words[start] + space.substring(0, maxWidth - sum);
                    res.add(line);
                } else {
                    int x = (maxWidth - sum) / (i - start - 1);
                    int m = (maxWidth - sum) % (i - start - 1);
                    StringBuilder str = new StringBuilder(words[start]);
                    String blank = space.substring(0, x);
                    for (int k = start + 1; k < i; k++) {
                    	str.append(" ");
                        if (k - start <= m) {
                            str.append(" ");
                        }
                        str.append(blank);
                        str.append(words[k]);
                    }
                    res.add(str.toString());
                }
                start = i;
                sum = words[i].length();
            } else {
                sum += words[i].length() + 1;
            }
        }
        
        
        if (start < words.length) {
        	int len = words[start].length();
        	StringBuilder str = new StringBuilder(words[start]);
        	for (int i = start + 1; i < words.length; i++) {
        		str.append(" ");
        		str.append(words[i]);
        		len += words[i].length() + 1;
        	}
        	str.append(space.substring(0, maxWidth - len));
        	res.add(str.toString());
        }
//        if (start < words.length) {
//            if (start == words.length - 1) {
//                String line = words[start] + space.substring(0, maxWidth - sum);
//                res.add(line);
//            } else {
//                int x = (maxWidth - sum) / (words.length - start - 1);
//                int m = (maxWidth - sum) % (words.length - start - 1);
//                StringBuilder str = new StringBuilder(words[start]);
//                String blank = space.substring(0, x);
//                for (int k = start + 1; k < words.length; k++) {
//                	str.append(" ");
//                    if (k - start < m) {
//                        str.append(" ");
//                    }
//                    str.append(blank);
//                    str.append(words[k]);
//                }
//                res.add(str.toString());
//            }
//        }
        
        return res;
    }
	
	public static void main(String[] args) {
		Text_Justification tmp = new Text_Justification();
		String[] words = {"Here","is","an","example","of","text","justification."};
		int maxWidth = 16;
		List<String> res = tmp.fullJustify(words, maxWidth);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i));
			System.out.println(res.get(i).length());
		}
	}
}
