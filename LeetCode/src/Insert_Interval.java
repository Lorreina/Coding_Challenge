import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 57. Insert Interval
 * @author lorreina
 *
 */
public class Insert_Interval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        
        int left = 0;
        int right = intervals.size() - 1;
        for (left = 0; left < intervals.size(); left++) {
            if (newInterval.start <= intervals.get(left).end) {
                break;
            }
        }
        
        for (right = intervals.size() - 1; right >= 0; right--) {
            if (newInterval.end >= intervals.get(right).start) {
                break;
            }
        }
        
        if (left > right) {
            intervals.add(left, newInterval);
        } else {
            intervals.get(left).start = Math.min(intervals.get(left).start,  newInterval.start);
            intervals.get(left).end = Math.max(intervals.get(left).end,  newInterval.end);
            for (int i = left + 1; i <= right; i++) {
                intervals.remove(left + 1);
            }
        }
        
        return intervals;
    }
	
	public static class Interval {
    	int start;
    	int end;
    	Interval() { start = 0; end = 0; }
    	Interval(int s, int e) { start = s; end = e; }
    }
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval> ();
		intervals.add(new Interval(1, 5));
		intervals.add(new Interval(6, 8));
		Interval newInterval = new Interval(0,9);
		Insert_Interval tmp = new Insert_Interval();
		List<Interval> res = tmp.insert(intervals, newInterval);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i).start);
			System.out.print(" ");
			System.out.println(res.get(i).end);
		}
	}
}
