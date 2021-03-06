import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 352. Data Stream as Disjoint Intervals
 * @author lorreina
 *
 */
public class Data_Stream_as_Disjoint_Intervals {
	/**
	 * Definition for an interval.
	 * public class Interval {
	 *     int start;
	 *     int end;
	 *     Interval() { start = 0; end = 0; }
	 *     Interval(int s, int e) { start = s; end = e; }
	 * }
	 */
	public class SummaryRanges {
	    List<Interval> list;
	    
	    /** Initialize your data structure here. */
	    public SummaryRanges() {
	        list = new ArrayList<Interval> ();
	    }
	    
	    public void addNum(int val) {
	        if (list == null || list.size() == 0) {
	            list.add(new Interval(val, val));
	            return;
	        }
	        
	        int i = 1;
	        for (i = 0; i < list.size(); i++) {
	            if (val >= list.get(i).start && val <= list.get(i).end) {
	                return;
	            }
	            if (val < list.get(i).start) {
	                if (i > 0 && val == list.get(i - 1).end + 1 && val + 1 == list.get(i).start) {
	                    list.get(i - 1).end = list.get(i).end;
	                    list.remove(i);
	                    return;
	                } else if (i > 0 && val == list.get(i - 1).end + 1) {
	                    list.get(i - 1).end = val;
	                    return;
	                } else if (val + 1 == list.get(i).start) {
	                    list.get(i).start = val;
	                    return;
	                }
	                break;
	            }
	        }
	        if (i == list.size()) {
	            if (val == list.get(i - 1).end + 1) {
	                list.get(i - 1).end = val;
	            } else {
	                list.add(new Interval(val, val));
	            }
	        } else {
	            list.add(i, new Interval(val, val));
	        }
	        
	        return;
	    }
	    
	    public List<Interval> getIntervals() {
	        return this.list;
	    }
	}
	
    public class Interval {
    	int start;
    	int end;
    	Interval() { start = 0; end = 0; }
    	Interval(int s, int e) { start = s; end = e; }
    }

	/**
	 * Your SummaryRanges object will be instantiated and called as such:
	 * SummaryRanges obj = new SummaryRanges();
	 * obj.addNum(val);
	 * List<Interval> param_2 = obj.getIntervals();
	 */
}
