import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Chad li
 * @Date : 2020/2/15 21:27
 * @Version 1.0
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length < 2){
            return 0;
        }
        int[] profit = new int[prices.length+2];
        for(int i=prices.length-2;i>=0;i--){
            for(int j=i+1;j<prices.length;j++){
                profit[i] = Math.max(Math.max(prices[j]-prices[i]+profit[j+2],profit[j]),profit[i]);
            }
        }
        return profit[0];
    }

    private int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[] buy= new int[prices.length + 1]; // have 1 stock on ith day
        int[] sell = new int[prices.length + 1]; // have 0 stock on ith day
        sell[1]=Math.max(0, prices[1]-prices[0]); // have nothing, or buy on buy on 0th day and sell on 1st day
        buy[0]=-prices[0]; // buy on 0th day
        buy[1]=Math.max(buy[0], -prices[1]); // buy on 0th day, or nothing on 0th day and buy on 1st day
        sell[1] = Math.max(0, prices[1]-prices[0]);  // have nothing or buy on 0th day and sell on 1st day
        for (int i=2; i<prices.length; i++) {
            //do not buy on ith or buy on ith
            buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i]);
            //do not sell on ith or sell on ith
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
        }
        return sell[prices.length-1];
    }

    private int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int buy,preBuy,sell,preSell;
        preSell = 0;
        preBuy = -prices[0];
        sell = Math.max(preSell,preBuy+prices[1]);
        buy = Math.max(preBuy,-prices[1]);
        for (int i=2; i<prices.length; i++) {
            preBuy = buy;
            // buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i]);
            buy = Math.max(buy,preSell - prices[i]);
            preSell = sell;
            // sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
            sell = Math.max(sell, preBuy + prices[i]);
        }
        return sell;
    }
}
