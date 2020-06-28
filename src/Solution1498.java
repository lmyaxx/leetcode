import java.util.Arrays;

public class Solution1498 {
    public int numSubseq(int[] nums, int target) {
        long res = 0;
        Arrays.sort(nums);
        long[] dp = new long[nums.length+1];
        dp[0] = 1;
        for(int i=0;i<nums.length;i++){
            dp[i+1] = (dp[i]<<1)%1000000007;
            int k = lessOrEqual(nums,Math.min(target-nums[i],nums[i]),i);
            if(k==i){
                res +=1;
                k--;
            }
            if(k!=-1){
                // res = (res + (dp[k+1]-1) * dp[Math.max(i-k-1,0)])%1000000007;
                res = (res + (dp[i] - dp[i-k-1]+1000000007))%1000000007;
            }
        }
        return (int)res;
    }

    private int lessOrEqual(int[] nums, int target, int right){
        int left = 0;
        while(left<=right){
            int mid = (left+ right) /2;
            if(nums[mid]>target){
                right = mid - 1;
            }else{
                left= mid + 1;
            }
        }
        return left - 1;
    }
}
