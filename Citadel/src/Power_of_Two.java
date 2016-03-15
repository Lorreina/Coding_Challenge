
public class Power_of_Two {
	public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        
        int i =0;
        for (i = 0; i < 32; i++) {
            if ((n & 1) != 0) {
                n = n >> 1;
                break;
            }
            n = n >> 1;
        }
        
        for (int j = i; j < 32; j++) {
            if ((n & 1) != 0) {
                return false;
            }
            n = n >> 1;
        }
        return true;
    }
}
