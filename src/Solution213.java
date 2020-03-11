/**
 * @Author : Chad li
 * @Date : 2020/3/11 10:45
 * @Version 1.0
 */
public class Solution213 {
    public int rob(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        // divide it into two case， rob at pos 0， not rob at pos 0
        return Math.max(rob(nums,1,nums.length-1),rob(nums,2,nums.length-2)+nums[0]);
    }

    private int rob(int[] nums, int start, int end){
        int last = 0, cur = 0;
        while(start<=end){
            int temp = cur;
            cur = Math.max(cur,last + nums[start]);
            last = temp;
        }
        return Math.max(last,cur);
    }
}
