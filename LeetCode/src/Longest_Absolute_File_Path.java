import java.util.ArrayList;

/**
 * Longest Absolute File Path
 * @author lorreina
 *
 */
public class Longest_Absolute_File_Path {
	public static int lengthLongestPath(String input) {
        String[] array = input.split("\\n");
        ArrayList<Integer> list = new ArrayList<Integer> ();
        list.add(array[0].length());
        
        int res = 0;
        for (int i = 1; i < array.length; i++) {
            int level = countLevel(array[i]);
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
	
	public static void main(String[] args) {
		int a = lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
		int b = lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
		int c = lengthLongestPath("dir\n	file");
		System.out.println(c);
	}
}