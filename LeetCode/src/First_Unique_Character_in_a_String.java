
public class First_Unique_Character_in_a_String {
	public static int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (arr[index] == -1) {
                continue;
            } else if (arr[index] > 0) {
                arr[index] = -1;
            } else {
                arr[index] = i + 1;
            }
        }
        
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 0) {
                continue;
            }
            if (arr[i] < minIndex || minIndex == 0) {
                minIndex = arr[i];
            }
        }
        
        return minIndex - 1;
    }
	
	public static void main(String[] args) {
		String s = "dabbcb";
		System.out.println(firstUniqChar(s));
	}
}
