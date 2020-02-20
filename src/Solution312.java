/**
 * @Author : Chad li
 * @Date : 2020/2/20 9:12
 * @Version 1.0
 */
public class Solution312 {
    public int maxCoins(int[] inums) {
        int count = 0;
        int[] nums = new int[inums.length+2];
        nums[count++] = 1;
        for(int num:inums){
            if(num!=0){
                nums[count++] = num;
            }
        }
        nums[count++] = 1;
        int[][] dp = new int[count][count];
        for(int length = 3; length<=count; length++){
            for(int start = 0,end=start + length -1;end<count; start++, end++){
                for(int split = start+1;split<end; split++){
                    dp[start][end] = Math.max(dp[start][end],
                            nums[start]*nums[split]*nums[end] + dp[start][split] + dp[split][end] );
                }
            }
        }
        return dp[0][count-1];
    }

}
