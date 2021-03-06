/**
 * LeetCode
 * 69. Sqrt(x)
 * @author lorreina
 *
 */
public class mySqrt {
	public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int root = x / 2;
        while (root > (x / root)) { // avoid overflow
            root = (root + x / root) / 2;
        }
        
        return root;
    }
	
	public static void main(String[] args) {
		String s = "2e3";
		System.out.println(Integer.parseInt(s));
	}
}
