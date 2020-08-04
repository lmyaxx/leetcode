package solution001_200;

public class Solution096 {
    public int numTrees(int n) {
        int []dp = new int[n+1];
        if(n<=1) return 1;
        dp[0]=dp[1]=1;
        for(int len=2;len<=n;len++){
            for(int i=0;i<=len;i++){
                dp[len]+=dp[i]*dp[len-1-i];
            }
        }
        return dp[n];
    }
}
