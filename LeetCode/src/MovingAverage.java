/**
 * LeetCode
 * 346. Moving Average from Data Stream
 * @author lorreina
 *
 */

public class MovingAverage {
    int size;
    int one, two, three;
    int count;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.one = 0;
        this.two = 0;
        this.three = 0;
        this.count= 0;
    }
    
    public double next(int val) {
        count++;
        this.one = this.two;
        this.two = this.three;
        this.three = val;
        if (count < 3) {
            return (double) (this.one + this.two + this.three) / count;
        }
        
        return (double) (this.one + this.two + this.three) / 3;
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
