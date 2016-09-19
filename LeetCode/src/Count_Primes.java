/**
 * LeetCode
 * 204. Count Primes
 * @author lorreina
 *
 */
public class Count_Primes {
//	public int countPrimes(int n) {
//        boolean[] notPrime = new boolean[n];
//        
//        int count = 0;
//        for (int i = 2; i < n; i++) {
//            if (notPrime[i] == false) {
//                count++;
//                for (int j = 2; j * i < n; j++) {
//                    notPrime[j * i] = true;
//                }
//            }
//        }
//        return count;
//    }
	
	public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        } 
        boolean[] isComposite = new boolean[n];
        
        // number 1 is not prime
        isComposite[0] = true;
        isComposite[1] = true;
        
        for (int i = 2; i < n ; i++) {
            if (isComposite[i] == true) {
                continue;
            } else {
                for (int j = i * i; j < n; j += i) {
                    isComposite[j] = true;
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!isComposite[i]) {
                count++;
            }
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		Count_Primes tmp = new Count_Primes();
		System.out.println(tmp.countPrimes(6));
	}
}
