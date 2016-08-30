
public class Solution {
	public int solution(int[] A) {
        // write your code in Java SE 8
		int count = 0;
		int i = 1;
		int j = A.length - 1;
		int isSmall = 0;
		for (i = 1; i < A.length; i++) {
			if (A[i] == A[0]) {
				continue;
			}
			count++;//found local extrema at the beginning of the array.
			break;
		}
		
		if (i == A.length) {
		    return 1;
		}
		
		for (j = A.length - 1; j > i; j--) {
			if (A[j] == A[A.length - 1]) {
				continue;
			}
			count++; // found local extrema at the end of the array.
			break;
		}
		
		for (int k = i + 1; k < j; k++) {
			
			if (A[k] == A[k + 1]) {
				if (A[k] == A[k - 1]) {
					continue;
				} else if (A[k] > A[k - 1]) {
					isSmall = -1;
				} else {
					isSmall = 1;
				}
			}
			if (A[k] > A[k - 1] && A[k] > A[k + 1]) {
				count++;
			} else if (A[k] < A[k - 1] && A[k] < A[k + 1]){
				count++;
			} else if (A[k] == A[k - 1]) {
				if (A[k] < A[k + 1] && isSmall == 1) {
					count++;
				} else if (A[k] > A[k + 1] && isSmall == -1) {
					count++;
				}
			}
		}
		
		return count;
    }
	
	
}
