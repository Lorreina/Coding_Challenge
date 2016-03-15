import java.util.List;

public class Merge_Intervals {
	public List<Interval> merge(List<Interval> intervals) {
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
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
}
