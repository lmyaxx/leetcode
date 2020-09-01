package solution401_600;

public class Solution0486 {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for(int k = 1; k <= len ; k++ ){
            int start = 0, end = k - 1;
            while(end<len){
                if(k==1){
                    dp[start][end] = nums[start];
                }else{
                    dp[start][end] = Math.max(nums[start] - dp[start+1][end], nums[end]-dp[start][end-1]);

                }
                start++;
                end++;

            }
        }
        return dp[0][len-1] >= 0;
    }
}
