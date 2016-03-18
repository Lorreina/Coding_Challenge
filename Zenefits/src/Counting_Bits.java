import java.util.Arrays;

public class Counting_Bits {
	public static int[] countBits(int num) {
        // (n + 1) is the number of valid bits of integer num
        int n = 0;
        int offset = 0x40000000;
        for (int i = 30; i >= 0; i--) {
            if ((offset & num) != 0) {
                n = i;
                break;
            } else {
                offset = offset >> 1;
            }
        }
        
        int[] count = new int[num + 1];
        count[0] = 0;
        
        // divide the number series into several groups according to its first valid bit
        // for example:{0}, {1}, {2,3}, {4,5,6,7}, {8-15}, {16-31}
        // using DP function
        for (int i = 0; i < n; i++) {
            int start = 1 << i;
            for (int j = start; j < start * 2; j++) {
                count[j] = count[j - start] + 1;
            }
        }
        
        // generate value for the last group (which is not a complete group)
        int start = 1 << n;
        for (int i = start; i <= num; i++) {
            count[i] = count[i - start] + 1;
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(countBits(2)));
	}
}
