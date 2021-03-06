import java.util.ArrayList;

/**
 * LeetCode
 * 313. Super Ugly Number
 * @author lorreina
 *
 */
public class Super_Ugly_Number {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1) {
            return 1;
        }

        ArrayList<Integer> list = new ArrayList<Integer> ();
        list.add(1);
        int[] index = new int[primes.length];
        
        int res = 1;
        for (int i = 1; i < n; i++) {
            int minNum = Integer.MAX_VALUE;
            int minJ = 0;
            for (int j = 0; j < index.length; j++) {
                if (j > 0 && index[j] == 0 && 0 == index[j - 1]) {
                    break;
                }
                if (list.get(index[j]) * primes[j] == res) {
                    index[j]++;
                }
                if (list.get(index[j]) * primes[j] < minNum) {
                    minNum = list.get(index[j]) * primes[j];
                    minJ = j;
                }
            }
            res = minNum;
            list.add(minNum);
            index[minJ]++;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	Super_Ugly_Number tmp = new Super_Ugly_Number();
    	int n = 10;
    	int[] primes = {2,5,7,11,13,17,23,29,43,53};
    	System.out.println(tmp.nthSuperUglyNumber(n, primes));
    }
}
