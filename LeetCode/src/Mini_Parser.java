import java.util.ArrayList;

public class Mini_Parser {
	public NestedInteger deserialize(String s) {
        
        return helper(s);
    }
    
    private NestedInteger helper(String s) {
        NestedInteger res = new NestedInteger();
        if (!s.contains("[")) {
            int num = Integer.parseInt(s);
            res.setInteger(num);
            return res;
        } else {
            int left = 0, right = s.length();
            int start = -1;
            int count = 0;
            
            if (s.charAt(0) == '[') {
                left++;
                right--;
            }
            for (int i = left; i < right; i++) {
                char c = s.charAt(i);
                if (c == ',') {
                    if (start == -1 || count > 0) {
                        continue;
                    } else {
                        res.add(helper(s.substring(start, i)));
                        start = -1;
                    }
                } else if (c == '[') {
                    count++;
                } else if (c == ']') {
                    count--;
                }
                if (start == -1 && c != ',') {
                    start = i;
                }
            }
            
            if (start >= 0 && count == 0) {
                res.add(helper(s.substring(start, right)));
            }
        }
        
        return res;
    }
    
    public class NestedInteger {
    	int val;
    	boolean isInteger;
    	ArrayList<NestedInteger> list;
    	
    	public NestedInteger() {
    	}
    	
    	public NestedInteger(int value) {
    		this.isInteger = true;
    		this.val = value;
    	}
    	
    	public void add(NestedInteger ni) {
    		this.isInteger = false;
    		this.list.add(ni);
    	}
    	
    	// Set this NestedInteger to hold a single integer.
    	public void setInteger(int value) {
    		this.isInteger = true;
    		this.val = value;
    	}
    }
    
    
    /*
    public interface NestedInteger {
    	// Constructor initializes an empty nested list.
//    	public NestedInteger() {
//		}
    	
    	// Constructor initializes a single integer.
//    	public NestedInteger(int value) {
//		}
    	
    	// @return true if this NestedInteger holds a single integer, rather than a nested list.
    	public boolean isInteger();
    	// @return the single integer that this NestedInteger holds, if it holds a single integer
    	// Return null if this NestedInteger holds a nested list
    	public Integer getInteger();
    	// @return the nested list that this NestedInteger holds, if it holds a nested list
    	// Return null if this NestedInteger holds a single integer
    	public List<NestedInteger> getList();
    	
    	// Set this NestedInteger to hold a nested list and adds a nested integer to it.
    	public void add(NestedInteger ni);
    	
    	// Set this NestedInteger to hold a single integer.
    	public void setInteger(int value);
    }
   	*/
}
