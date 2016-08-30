import java.util.ArrayList;

public class Maximum_Product_Subarray {
	public static int maxProduct(int[] nums) {
        ArrayList<Integer> start = new ArrayList<Integer> ();
        ArrayList<Integer> end = new ArrayList<Integer> ();
        ArrayList<Integer> prod = new ArrayList<Integer> ();
        int i = 0;
        int product = 1;
        int maxProd = Integer.MIN_VALUE;
        
        while (i < nums.length) {
            if (nums[i] != 0) {
            	start.add(i);
            	product = nums[i];
                break;
            }
            maxProd = 0;
            i++;
        }
        if (i == nums.length) {
            return 0;
        }
        
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == 0) {
            	maxProd = 0;
                if (nums[j - 1] != 0) {
                    end.add(j - 1);
                    prod.add(product);
                }
                continue;
            }
            if (nums[j - 1] == 0) {
                start.add(j);
                product = 1;
            }
            product *= nums[j];
        }
        
        if (nums[nums.length - 1] != 0) {
        	end.add(nums.length - 1);
        	prod.add(product);
        }
        
        
        for (int j = 0; j < start.size(); j++) {
            maxProd = Math.max(maxProd, findMax(nums, start.get(j), end.get(j), prod.get(j)));
        }
        
        return maxProd;
    }
    
    private static int findMax(int[] nums, int start, int end, int prod) {
        if (prod > 0) {
            return prod;
        }
        if (start == end) {
            return prod;
        }
        
        int leftProd = 1;
        int rightProd = 1;
        for (int i = start; i < end + 1; i++) {
            leftProd *= nums[i];
            if (nums[i] < 0) {
                break;
            }
        }
        
        for (int i = end; i >= start; i--) {
            rightProd *= nums[i];
            if (nums[i] < 0) {
                break;
            }
        }
        
        return prod / (Math.max(leftProd, rightProd));
    }
    
    public static void main(String[] args) {
    	int[] nums = {-2, 0, -1};
    	System.out.println(maxProduct(nums));
    }
}	
