package solution601_800;

import java.util.PriorityQueue;

public class Solution0659 {
    public boolean isPossible(int[] nums) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long last = Long.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i], count = 1;
            while(i + 1 < nums.length && nums[i+1] == num){
                count++; i++;
            }
            if(nums[i] != last + 1){
                while(!queue.isEmpty()){
                    if(queue.poll()<3){
                        return false;
                    }
                }
                while(count-->0){
                    queue.offer(1);
                }
            }else{
                PriorityQueue pq = new PriorityQueue();
                while(count>0&&!queue.isEmpty()){
                    count--;
                    pq.offer(queue.poll() + 1);
                }
                while(!queue.isEmpty()){
                    if(queue.poll()<3){
                        return false;
                    }
                }
                while(count-->0){
                    pq.offer(1);
                }
                queue = pq;
            }
            last = num;
        }

        while(!queue.isEmpty()){
            if(queue.poll()<3){
                return false;
            }
        }
        return true;
    }
}
