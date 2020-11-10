public class Solution1646 {
    public int getMaximumGenerated(int n) {
        if(n<=0){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int ans = 1;
        for(int i = 2; i <= n; i++){
            if(i % 2==0){
                dp[i] = dp[i/2];
            }else{
                dp[i] = dp[i/2] + dp[i - i / 2];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
