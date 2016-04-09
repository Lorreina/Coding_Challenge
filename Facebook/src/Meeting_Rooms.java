import java.util.Arrays;
import java.util.Comparator;

public class Meeting_Rooms {
	public static boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }
        
        // sort intervals
        Arrays.sort(intervals, new Comparator<Interval> () {
            public int compare(Interval interval1, Interval interval2) {
                Integer start1 = (Integer) interval1.start;
                Integer start2 = (Integer) interval2.start;
                Integer end1 = (Integer) interval1.end;
                Integer end2 = (Integer) interval2.end;
                if (!start1.equals(start2)) {
                    return start1.compareTo(start2);
                } else {
                    return end1.compareTo(end2);
                }
            }
        }); 
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        
        return true;
    }
	
	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static void main(String[] args) {
		Interval[] intervals = new Interval[2];
		intervals[0] = new Interval(1, 3);
		intervals[1] = new Interval(2, 10);
		System.out.println(canAttendMeetings(intervals));
	}
}
