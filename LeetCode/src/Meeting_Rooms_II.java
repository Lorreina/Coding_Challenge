import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode
 * 253. Meeting Rooms II
 * @author lorreina
 *
 */
public class Meeting_Rooms_II {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        // sort intervals
        Arrays.sort(intervals, new Comparator<Interval> () {
            public int compare(Interval interval1, Interval interval2) {
                /*
                Integer start1 = (Integer) interval1.start;
                Integer start2 = (Integer) interval2.start;
                Integer end1 = (Integer) interval1.end;
                Integer end2 = (Integer) interval2.end;
                if (!start1.equals(start2)) {
                    return start1.compareTo(start2);
                } else {
                    return end1.compareTo(end2);
                }
                */
                return ((Integer) interval1.start).compareTo((Integer) interval2.start);
            }
        }); 
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer> ();
        queue.add(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            int earliest = queue.peek();
            if (intervals[i].start >= earliest) {
                queue.poll();
            }
            queue.offer(intervals[i].end);
        }
        
        return queue.size();
    }
    
    public class Interval {
    	int start;
    	int end;
    	Interval() { start = 0; end = 0; }
    	Interval(int s, int e) { start = s; end = e; }
    }
}
