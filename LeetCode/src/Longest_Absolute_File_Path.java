import java.util.Stack;

/**
 * Longest Absolute File Path
 * @author lorreina
 *
 */
public class Longest_Absolute_File_Path {
	
	// version 1
	/*
	public static int lengthLongestPath(String input) {
        String[] array = input.split("\\n");
        ArrayList<Integer> list = new ArrayList<Integer> ();
//        list.add(array[0].length());
        
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            int level = countLevel(array[i]);
            if (level == 0) {
            	list.clear();
            	if (array[i].contains(".")) {
            		res = Math.max(res, countLength(array[i]));
            	} else {
            		list.add(countLength(array[i]));
            	}
            	continue;
            }
            int length = list.get(level - 1) + countLength(array[i]) + 1;
            if (array[i].contains(".")) {
                res = Math.max(res, length);
            }
            if (level >= list.size()) {
                list.add(length);
            } else {
                list.set(level, length);
            }
        }
        
        return res;
        
    }
    
    private static int countLevel(String input) {
        return input.length() - input.replace("\t", "").length();
    }
    
    private static int countLength(String input) {
        return input.length() - countLevel(input);
    }
    */
	
	
	// version 2
	public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        
        String[] paths = input.split("\\n");
        Stack<Dir> stack = new Stack<Dir> ();
        int maxLen = 0;
        int currLen = 0;
        
        for (int i = 0; i < paths.length; i++) {
            int level = countLevel(paths[i]);
            int len = paths[i].length() - level;
            
            while (!stack.isEmpty() && stack.peek().level >= level) {
                currLen = currLen - stack.peek().len;
                stack.pop();
            }
            
            if (isFile(paths[i])) {
                maxLen = Math.max(maxLen, currLen + len + level);
            } else {
                stack.push(new Dir(len, level));
                currLen = currLen + len;
            }
        }
        
        return maxLen;
    }
    
    private boolean isFile(String s) {
        return s.contains(".");
    }
    
    private int countLevel(String s) {
        return s.length() - s.replace("\t", "").length();
    }
    
    class Dir {
        int len;
        int level;
        
        public Dir(int len, int level) {
            this.len = len;
            this.level = level;
        }
    }
	
	public static void main(String[] args) {
//		int a = lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
//		int b = lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
//		int c = lengthLongestPath("dir\n  file.txt");
		Longest_Absolute_File_Path tmp = new Longest_Absolute_File_Path();
		int d = tmp.lengthLongestPath("dir\n  file.txt");
		System.out.println(d);
	}
}
