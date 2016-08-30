import java.io.*;
import java.util.*;

public class Test {
	static long mirroredNumber(int numberDigits) {
        // The return value of "int" can not handle cases when numberDigits >= 6, t
        if (numberDigits == 0) {
            return 0;
        } 
        
        long maxNum = 0;
        int biggestNum = (int)Math.pow(10, numberDigits) - 1;
        int smallestNum = (int)Math.pow(10, numberDigits - 1);
        for (int i = biggestNum; i > smallestNum; i--) {
            if ((long)i * (long)i < maxNum) {
                return maxNum;
            }
            for (int j = i; j > smallestNum; j--) {
                if (isMirroredNumber((long)i * (long)j)) {
                    maxNum = Math.max(maxNum, (long)i * (long)j);
                }
            }
        }
        return maxNum;
    }

    static boolean isMirroredNumber(long number) {
        String s = ((Long)number).toString();
        int i = 0, j = s.length() - 1;
        while (i < j) {
           if (s.charAt(i) == s.charAt(j)) {
               i++;
               j--;
           } else {
               return false;
           }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	System.out.println(mirroredNumber(6));
    	String x = "abc";
//    	CharSequence s = 
//    	x.indexOf(str)
    	Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
    }
}
