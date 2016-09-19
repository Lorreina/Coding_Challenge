import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode
 * 355. Design Twitter
 * @author lorreina
 *
 */
public class Design_Twitter {
	
	public static class Twitter {
	    HashMap<Integer, ArrayList<Integer>> tweetMap;
	    HashMap<Integer, LinkedHashSet<Integer>> followMap;
	    HashMap<Integer, Integer> tweetIdMap;
	    int id;
	    
	    /** Initialize your data structure here. */
	    public Twitter() {
	        this.tweetMap = new HashMap<Integer, ArrayList<Integer>> ();
	        this.followMap = new HashMap<Integer, LinkedHashSet<Integer>> ();
	        this.tweetIdMap = new HashMap<Integer, Integer> ();
	        this.id = 0;
	    }
	    
	    /** Compose a new tweet. */
	    public void postTweet(int userId, int tweetId) {
	        if (tweetMap.containsKey(userId)) {
	            tweetMap.get(userId).add(id);
	        } else {
	            ArrayList<Integer> tweetList = new ArrayList<Integer> ();
	            tweetList.add(id);
	            tweetMap.put(userId, tweetList);
	            followMap.put(userId, new LinkedHashSet<Integer> ());
	        }
	        
	        tweetIdMap.put(id, tweetId);
	        id++;
	    }
	    
	    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	    public List<Integer> getNewsFeed(int userId) {
	        List<Integer> res = new ArrayList<Integer> ();
	        if (!tweetMap.containsKey(userId)) {
	            return res;
	        }
	        
	        int numLimit = 10;
	        /*
	        PriorityQueue<Integer> queue = new PriorityQueue<Integer, new Comparator<Integer> () {
	            public int compare(Integer a, Integer b) {
	                return -a.compareTo(b);
	            }
	        });
	        */
	        PriorityQueue<Integer> queue = new PriorityQueue<Integer> ();
	        
	        ArrayList<Integer> selfTweetList = tweetMap.get(userId);
	        for (int i = 0; i < selfTweetList.size(); i++) {
	            queue.add(selfTweetList.get(i));
	            if (queue.size() > numLimit) {
	                queue.poll();
	            }
	        }
	        
	        LinkedHashSet<Integer> followList = followMap.get(userId);
	        Iterator<Integer> itr = followList.iterator();
	        while(itr.hasNext()){
	            ArrayList<Integer> tweetList = tweetMap.get(itr.next());
	            for (int j = 0; j < tweetList.size(); j++) {
	                queue.add(tweetList.get(j));
	                if (queue.size() > numLimit) {
	                    queue.poll();
	                }
	            }
	        }
	        
	        while (!queue.isEmpty()) {
	            res.add(0, tweetIdMap.get(queue.poll()));
	        }
	        
	        return res;
	    }
	    
	    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	    public void follow(int followerId, int followeeId) {
	        if (followerId == followeeId) {
	            return;
	        }
	        // follower is a new user
	        if (!followMap.containsKey(followerId)) {
	            tweetMap.put(followerId, new ArrayList<Integer> ());
	            followMap.put(followerId, new LinkedHashSet<Integer> ());
	        } 
	        
	        // followee is a new user
	        if (!followMap.containsKey(followeeId)) {
	            tweetMap.put(followeeId, new ArrayList<Integer> ());
	            followMap.put(followeeId, new LinkedHashSet<Integer> ());
	        }
	        
	        followMap.get(followerId).add(followeeId);
	    }
	    
	    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	    public void unfollow(int followerId, int followeeId) {
	        if (followerId == followeeId) {
	            return;
	        }
	        if (followMap.containsKey(followerId)) {
	            followMap.get(followerId).remove(followeeId);
	        }
	    }
	}
	

	/**
	 * Your Twitter object will be instantiated and called as such:
	 * Twitter obj = new Twitter();
	 * obj.postTweet(userId,tweetId);
	 * List<Integer> param_2 = obj.getNewsFeed(userId);
	 * obj.follow(followerId,followeeId);
	 * obj.unfollow(followerId,followeeId);
	 */
	
	public static void main(String[] args) {
		Twitter obj = new Twitter();
		obj.postTweet(1,5);
		obj.getNewsFeed(1);
		obj.follow(1, 2);
		obj.postTweet(2, 6);
		obj.getNewsFeed(1);
		obj.unfollow(1, 2);
		obj.getNewsFeed(1);
	}
}
