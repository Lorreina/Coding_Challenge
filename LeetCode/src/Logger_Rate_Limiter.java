import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode
 * 359. Logger Rate Limiter
 * @author lorreina
 *
 */
public class Logger_Rate_Limiter {
	public static class Logger {
	    Map<String, Integer> map;

	    /** Initialize your data structure here. */
	    public Logger() {
	        map = new HashMap<String, Integer>();
	    }
	    
	    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	        If this method returns false, the message will not be printed.
	        The timestamp is in seconds granularity. */
	    public boolean shouldPrintMessage(int timestamp, String message) {
	        if (map.containsKey(message)) {
	            if ((timestamp - map.get(message)) >= 10) {
	                map.put(message, timestamp);
	                return true;
	            } else {
	                return false;
	            }
	        } else {
	            map.put(message, timestamp);
	            return true;
	        }
	    }
	}
	
	public static void main(String[] args) {
		Logger logger = new Logger();
		logger.shouldPrintMessage(1,"foo");
		logger.shouldPrintMessage(2,"bar");
		logger.shouldPrintMessage(3,"foo");
		logger.shouldPrintMessage(8,"bar");
		logger.shouldPrintMessage(10,"foo");
		logger.shouldPrintMessage(11,"foo");
	}
}
