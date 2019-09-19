package Common;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    private Queue<Integer> small, large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.add(num);
        // the size of small is not more than that of large
        if(small.size()>large.size()){
            large.add(small.poll());
            return;
        }
        if(small.size()==large.size()&&small.peek()>large.peek()){
            large.add(small.poll());
            small.add(large.poll());
            return;
        }
    }

    public double findMedian() {
        if(small.size()==large.size()){
            return  ((double)small.peek()+large.peek())/2;
        }else{
            return large.peek();
        }
    }
}
