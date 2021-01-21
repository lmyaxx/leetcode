package solution601_800;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author: chad li
 * @date: 2021/1/20
 * @discription:
 */
public class Solution0628 {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> sm = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> lg = new PriorityQueue<>();
        for(int num: nums){
            sm.add(num);
            lg.add(num);
            if(sm.size()>2){
                sm.poll();
            }
            if(lg.size()>3){
                lg.poll();
            }
        }

        int max3 = lg.poll();
        int max2 = lg.poll();
        int max1 = lg.poll();
        int min2 = sm.poll();
        int min1 = sm.poll();
        return max1 >0 ? max1 * Math.max(max2*max3, min1 * min2 ):max1 * Math.min(max2*max3, min1 * min2 );
    }
}
