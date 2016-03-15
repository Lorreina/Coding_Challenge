
public class Reverse_Bits {
	// you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int x = 0;
        for (int i = 0; i < 32; i++) {
            x = (x << 1) | (n & 1);
            n = n >> 1;
        }
        return x;
    }
    
    public static void main(String[] args) {
    	System.out.println(reverseBits(1));
    }
}
