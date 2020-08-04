package solution401_600;

import java.util.Arrays;

/**
 * @Author : Chad li
 * @Date : 2020/4/7 15:41
 * @Version 1.0
 */
public class Solution410 {
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        long[][] dp = new long[m+1][len+1];
        for(long[] arr:dp){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        long[] sums = new long[len+1];
        for(int i=1;i<=len;i++){
            sums[i] = sums[i-1] + nums[i-1];
            dp[1][i] = sums[i];
        }
        //dp[i][j] means the minimum of the biggest subSum when split the first j nums into i pieces
        //j>=i
        for(int i=2;i<=m;i++){
            for(int j=i;j<=len;j++){
                for(int k=i-1;k<j;k++){
                    //[1,k] into i-1 pieces;(k,j] into 1 piece
                    dp[i][j] = Math.min(dp[i][j],Math.max(dp[i-1][k],sums[j]-sums[k]));
                }
            }
        }
        return (int)dp[m][len];
    }
}
