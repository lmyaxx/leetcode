import java.util.Arrays;

public class Solution629 {
    public int kInversePairs(int n, int k) {
        // dp[i][j] means the number of cases when n = i and k<=j
        long[][] dp = new long[1001][1001];
        int mod = 1000000007;
        Arrays.fill(dp[1],1);
        for(int i=2;i<=n;i++){
            dp[i][0] = 1;
            for(int j=1;j<=k;j++){
                //[max(j-(i-1),0),j],
                int left = Math.max(j-(i-1),0);
                long single = dp[i-1][j];
                if(left!=0){
                    single = (single - dp[i-1][left-1] + mod) %mod;
                }
                dp[i][j] = (dp[i][j-1] + single)%mod;
            }
        }
        return (int)(k==0 ? dp[n][k] : dp[n][k] - dp[n][k-1] + mod)%mod;
    }
}
