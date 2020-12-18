import java.util.Arrays;

/**
 * @author: chad li
 * @date: 2020/12/18
 * @discription:
 */
public class Solution1681 {
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length, c = n / k;
        int[][] dp = new int[16][1<<16];
        for(int[] num : dp){
            Arrays.fill(num, 1000_000_000);
        }
        for(int i = 0; i < n; i ++){
            dp[i][1<<i] = 0;
        }
        for(int s = 0; s < 1 << n; s++){
            for (int i = 0; i < n; i++) {
                if((s & (1<<i)) == 0) continue;
                for (int j = 0; j < n; j++) {
                    if((s & (1<<j)) != 0) continue;
                    int t = s | (1<<j);
                    if(Integer.bitCount(s) % c == 0){
                        dp[j][t] = Math.min(dp[j][t], dp[i][s]);
                    }else if(nums[j] > nums[i]){
                        dp[j][t] = Math.min(dp[j][t], dp[i][s] + nums[j] - nums[i]);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i ++){
            ans = Math.min(ans, dp[i][(1<<n)-1]);
        }
        return ans >= 1e9 ? -1 : ans;
    }
}
