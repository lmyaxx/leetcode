import java.util.Arrays;

/**
 * @Author : Chad li
 * @Date : 2020/2/24 10:42
 * @Version 1.0
 */
public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        if(sum%2 ==1) {
            return false;
        }
        //case 1,1,1,100; where you have a big number which can not be splitted.
        for(int i:nums){
            if(i > sum/2) {
                return false;
            }
        }
        return helper(nums,nums.length-1, 0, sum/2);
    }

    private boolean helper(int[] nums, int end, int sum, int target){
        if(end<0 || sum> target){
            return false;
        }
        if(sum == target){
            return true;
        }
        return helper(nums, end - 1, sum + nums[end],target)||helper(nums,end-1,sum,target);
    }
    public boolean canPartition1(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        for(int i:nums){
            if(i > sum/2) {
                return false;
            }
        }
        sum /= 2;
        int n = nums.length;
        boolean[] dp = new boolean[sum+1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }

        return dp[sum];
    }
}
