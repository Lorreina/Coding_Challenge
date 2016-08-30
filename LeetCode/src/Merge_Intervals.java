import java.util.ArrayList;
import java.util.List;

public class Merge_Intervals {
	public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        int i = intervals.size() - 1;
        int j = 0;
        while (i >= 1){
            while (j < i) {
                if (intervals.get(i).end < intervals.get(j).start) {
                    j++;
                    continue;
                } else if (intervals.get(i).end <= intervals.get(j).end) {
                    intervals.get(j).start = Math.min(intervals.get(i).start, intervals.get(j).start);
                    intervals.remove(i);
                    break;
                } else if (intervals.get(i).start <= intervals.get(j).end) {
                    intervals.get(j).start = Math.min(intervals.get(j).start, intervals.get(i).start);
                    intervals.get(j).end = intervals.get(i).end;
                    intervals.remove(i);
                    break;
                } else {
                    j++;
                    continue;
                }
            }
            i--;
            j = 0;
        }
        return intervals;
        
    }
	
	/**
	 * Definition for an interval.
	 */
	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<Interval> ();
		intervals.add(new Interval(4, 5));
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(0, 1));
		merge(intervals);
		for (int i = 0; i < intervals.size(); i++) {
			System.out.print(intervals.get(i).start);
			System.out.print(", ");
			System.out.println(intervals.get(i).end);
		}
		
	}
}
