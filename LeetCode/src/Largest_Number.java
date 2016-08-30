
public class Largest_Number {
	public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        String[] string = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            string[i] = String.valueOf(nums[i]);
        }
        
        quickSort(string);
        StringBuilder result = new StringBuilder();
        
        if (string[string.length - 1].equals("0")) {
        	return "0";
        }
        
        for (int i = string.length - 1; i >= 0; i--) {
            result.append(string[i]);
        }
        
        return result.toString();
    }
    
    private void quickSort(String[] string) {
        quickSort(string, 0, string.length - 1);
    }
    
    private void quickSort(String[] string, int left, int right) {
        if (left >= right) {
            return;
        }
        
        String pivot = string[right];
        
        int partition = partition(string, left, right, pivot);
        quickSort(string, left, partition - 1);
        quickSort(string, partition + 1, right);
    }
    
    private int partition(String[] string, int left, int right, String pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;
        
        while (true) {
            while (true) {
                leftPointer++;
                if (compare(pivot, string[leftPointer]) <=0) {
                    break;
                }
            }
            while (rightPointer > 0) {
                rightPointer--;
                if (compare(pivot, string[rightPointer]) >=0) {
                    break;
                }
            }
            
            if (leftPointer >= rightPointer) {
                break;
            }
            swap(string, leftPointer, rightPointer);
        }
        
        swap(string, leftPointer, right);
        return leftPointer;
    }
    
    private void swap(String[] string, int i, int j) {
        String tmp = string[i];
        string[i] = string[j];
        string[j] = tmp;
    }
    
    private int compare(String a, String b) {
    	String ab = a + b;
    	String ba = b + a;
    	return ab.compareTo(ba);
    }
    
    public static void main(String[] args) {
    	Largest_Number wddwxy = new Largest_Number();
    	int[] nums = {3, 30, 34, 5, 9};
    	System.out.println(wddwxy.largestNumber(nums));
    }
}
