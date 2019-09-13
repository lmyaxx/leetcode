import java.util.*;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0||k==0) return new int[]{};
        //  num count
        Map<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int res[] = new int[nums.length-k+1];
        res[0] = ((TreeMap<Integer, Integer>) map).firstKey();
        for(int i=k;i<nums.length;i++){
            map.put(nums[i-k],map.get(nums[i-k])-1);
            if(map.get(nums[i-k])==0){
                map.remove(nums[i-k]);
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            res[i-k+1] = ((TreeMap<Integer, Integer>) map).firstKey();
        }
        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums.length==0||k==0) return new int[]{};
        //  num count
        int res[] = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            // keep the elements within the sliding window
            while(!deque.isEmpty()&&deque.peek()<i-k+1){
                deque.poll();
            }
            // keep the elements in the sliding window in decreasing order
            while(!deque.isEmpty()&&nums[deque.getLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            // add the biggest num to the result
            if(i-k+1>=0){
                res[i-k+1] = nums[deque.peek()];
            }
        }

        return res;
    }
}
