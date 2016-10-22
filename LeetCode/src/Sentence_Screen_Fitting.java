/**
 * LeetCode
 * 418. Sentence Screen Fitting
 * @author lorreina
 *
 */
public class Sentence_Screen_Fitting {
	public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length();
        int count = 0;
        int[] map = new int[len];
        
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ' ') {
                map[i] = 1;
            } else {
                map[i] = map[i - 1] - 1;
            }
        }
        
        for (int i = 0; i < rows; i++) {
            count += cols;
            count += map[count % len];
        }
        
        return count / len;
    }

	/*
	"abc de f abc de f abc de f ..." // start=0
	 012345                          // start=start+cols+adjustment=0+6+1=7 (1 space removed in screen string)
	        012345                   // start=7+6+0=13
	              012345             // start=13+6-1=18 (1 space added)
	                   012345        // start=18+6+1=25 (1 space added)
	                          012345
	*/
	
	public static void main(String[] args) {
		String[] sentence = {"I", "had", "apple", "pie"};
		String s = String.join(" ", sentence) + " ";
		System.out.println(s + "!");
	}
}