/**
 * @Author : Chad li
 * @Date : 2020/3/5 11:01
 * @Version 1.0
 */
public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][k];
        return helper(prices,k,0,0,0,dp);
    }
    private int helper(int[] prices, int k, int start,int lastBuy, int profit,int[][] dp){
        if(k<=0||start>=prices.length||dp[start][k]!=0){
            return dp[start][k];
        }
        int buy,sell;
        while(start+1<prices.length&&prices[start]>=prices[start+1]){
            start++;
        }
        buy = start;
        if(prices[buy]<prices[lastBuy]){
            lastBuy = buy;
        }
        while(start+1<prices.length&&prices[start]<=prices[start+1]){
            start++;
        }
        sell = start;
        dp[start][k] = helper(prices,k,start+1,lastBuy,profit,dp);
        dp[start][k-1] = helper(prices,k-1,start+1,start+1,profit + prices[sell] - prices[lastBuy],dp);
        return Math.max(dp[start][k],
                dp[start][k-1]);
    }
    public int maxProfit1(int k, int[] prices) {
        int maxProfit = 0;
        int len=0;
        int[] low = new int[prices.length/2];
        int[] high = new int[prices.length/2];
        for(int i=0;i<prices.length;i++){
            int buy,sell;
            while(i+1<prices.length&&prices[i] >= prices[i+1]){
                i++;
            }
            buy = i;
            while(i+1<prices.length&&prices[i] <= prices[i+1]){
                i++;
            }
            sell = i;
            if(buy!=sell){
                low[len] = prices[buy];
                high[len] = prices[sell];
                maxProfit +=  high[len] - low[len];
                len++;
            }
        }
        if(k>=len){
            return maxProfit;
        }
        //dp[i][j]: 在low[]
        int[][] dp = new int[k+1][len];
        for(int i=1;i<=k;i++){
            dp[i][0] = high[0] - low[0];
            int temp = -low[0];
            for(int j=1;j<len;j++){
                temp = Math.max(temp,dp[i-1][j-1] -low[j]);
                dp[i][j] = Math.max(dp[i][j-1],temp + high[j]);

            }
        }
        return dp[k][len-1];
    }

    public int maxProfit2(int k, int[] prices) {
        if(prices.length <= 1 || k == 0) {
            return 0;
        }
        if(2*k >= prices.length) {
            return unlimitedTrans(prices);
        }
        // 交易完成最多k次，持有股票时的最大利润
        int[] buy = new int[k+1];
        // 交易完成最多k次，不持有股票的最大利润
        int[] sell = new int[k+1];

        for(int i=0;i<buy.length;i++){
            buy[i] = Integer.MIN_VALUE;
        }
        buy[0] = -prices[0];
        for(int i=1;i<prices.length;i++){
            buy[0] = Math.max(buy[0],-prices[i]);
            for(int j=1;j<=k;j++){
                sell[j] = Math.max(sell[j],buy[j-1] + prices[i]);
                buy[j] = Math.max(buy[j],sell[j] - prices[i]);
            }
        }

        return sell[k];
    }

    public int unlimitedTrans(int[] prices) {
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            maxProfit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return maxProfit;
    }
}
