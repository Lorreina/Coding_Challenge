/**
 * LeetCode
 * 157. Read N Characters Given Read4
 * @author lorreina
 *
 */
public class Read_N_Characters_Given_Read4 {
	/* The read4 API is defined in the parent class Reader4.
    int read4(char[] buf); */
	
	
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        int times = n / 4;
        char[] tmp = new char[4];
        
        for (int i = 0; i < times; i++) {
            int plus = read4(tmp);
            
            for (int j = 0; j < 4; j++) {
                buf[count + j] = tmp[j];
            }
            
            count += plus;
            
            if (plus < 4) {
                return count;
            }
        }
        
        int read4 = Math.min(read4(tmp), n - count);
        
        for (int i = 0; i < read4; i++) {
            buf[count + i] = tmp[i];
        }
        
        return count + read4;
    }

	private int read4(char[] tmp) {
		// TODO Auto-generated method stub
		return 0;
	}
}
