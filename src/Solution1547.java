import java.util.Arrays;
import java.util.LinkedList;

public class Solution1547 {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] preSum = new int[cuts.length+2];
        System.arraycopy(cuts,0,preSum,1,cuts.length);
        preSum[preSum.length-1] = n;
        // System.out.println(Arrays.toString(preSum));
        //dp[i][j] means the minimum scores in the range[i,j]
        int[][] dp = new int[cuts.length+1][cuts.length+1];
        int K = 2;
        for(int k = 2; k<= cuts.length + 1; k++){
            for(int i = 0;i + k - 1< cuts.length +1; i++){
                int j = i + k -1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int mid = i; mid<j;mid++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][mid] + dp[mid+1][j]);
                }
                if((j-i)%(K-1)==0){
                    dp[i][j] += preSum[j+1] - preSum[i];
                }
            }
        }
        return dp[0][cuts.length];
    }
}
