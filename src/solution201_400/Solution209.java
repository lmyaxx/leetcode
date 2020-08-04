package solution201_400;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Chad li
 * @Date : 2020/3/10 11:39
 * @Version 1.0
 */
public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int result = Integer.MAX_VALUE;
        boolean isHavingOne = false;
        Queue<Integer> queue = new LinkedList<>();
        for(int num:nums){
            sum+=num;
            queue.offer(num);
            if(sum>s){
                isHavingOne = true;
                while(sum>s){
                    sum-=queue.poll();
                }
                result = Math.min(result,queue.size()+1);
            }
        }
        return isHavingOne ? result:0;
    }
}
