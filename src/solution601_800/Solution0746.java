package solution601_800;

/**
 * @author: chad li
 * @date: 2020/12/21
 * @discription:
 */
public class Solution0746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length<1){
            return 0;
        }
        int len = cost.length;
        int[] dp = new int[len+1];
        dp[0] = 0;  dp[1] = cost[0];
        for(int i = 2; i<= len; i++){
            dp[i] = Math.min(dp[i-2] + cost[i-1], dp[i-1] + cost[i-1]);
        }
        return Math.min(dp[len],dp[len-1]);
    }
}
