/*
 * LeetCode Problem
 * 318. Maximum Product of Word Lengths
 * 
 * bit manipulation
 * 
 */
public class Maximum_Product_of_Word_Lengths {
	public int maxProduct(String[] words) {
        if (words == null || words.length <= 1) {
            return 0;
        }
        int product = 0;
        int[] nums = new int[words.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = stringToInt(words[i]);
            for (int j = 0; j < i; j++) {
                if ((nums[j] & nums[i]) == 0) {
                    product = Math.max(product, words[i].length() * words[j].length());
                }
            }
        }
        
        return product;
    }
    
    private int stringToInt(String word) {
        int x = 0;
        if (word == null || word.length() == 0) {
            return x;
        }
        for (int i = 0; i < word.length(); i++) {
            x = x | (1 << (word.charAt(i) - 'a'));
        }
        return x;
    }
}
