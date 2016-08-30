/**
 * LeetCode
 * 362. Design Hit Counter
 * @author lorreina
 *
 */
public class Design_Hit_Counter {
	public static class HitCounter {
	    int[] counter;
	    int lastTime;

	    /** Initialize your data structure here. */
	    public HitCounter() {
	        counter = new int[300];
	        lastTime = 1;
	    }
	    
	    /** Record a hit.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public void hit(int timestamp) {
	        int thisHit = (timestamp - 1) % 300;
	        
	        cleanHelper(counter, timestamp, lastTime);
	        counter[thisHit] += 1;
	        lastTime = timestamp;
	    }
	    
	    private void cleanHelper(int[] counter, int thisTime, int lastTime) {
	        if (thisTime == lastTime) {
	            return;
	        }
	        if (thisTime - lastTime >= counter.length) {
	            clean(counter, 0, counter.length - 1);
	        }
	        
	        int thisHit = (thisTime - 1) % 300;
	        int lastHit = (lastTime - 1) % 300;
	        
	        if (thisHit > lastHit) {
	            clean(counter, lastHit + 1, thisHit);
	        } else {
	            clean(counter, 0, thisHit);
	            clean(counter, lastHit + 1, counter.length - 1);
	        }
	    }
	    
	    private void clean(int[] counter, int start, int end) {
	        for (int i = start; i <= end; i++) {
	            counter[i] = 0;
	        }
	    }
	    
	    /** Return the number of hits in the past 5 minutes.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public int getHits(int timestamp) {
	        int hits = 0;
	        int thisHit = (timestamp - 1) % 300;
	        int lastHit = (lastTime - 1) % 300;
	        cleanHelper(counter, timestamp, lastTime);
	        
	        for (int i = 0; i < counter.length; i++) {
	            hits += counter[i];
	        }
	        
	        return hits;
	    }
	}

	/**
	 * Your HitCounter object will be instantiated and called as such:
	 * HitCounter obj = new HitCounter();
	 * obj.hit(timestamp);
	 * int param_2 = obj.getHits(timestamp);
	 */
	
	public static void main(String[] args) {
		HitCounter counter = new HitCounter();
		counter.hit(1);
		counter.hit(2);
		counter.hit(3);
		System.out.println(counter.getHits(4));
		counter.hit(300);
		System.out.println(counter.getHits(300));
		System.out.println(counter.getHits(301));
		
	}
}
