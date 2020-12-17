package solution601_800;

/**
 * @author: chad li
 * @date: 2020/12/17
 * @discription:
 */
public class Solution0714 {
    public int maxProfit(int[] prices, int fee) {
        int one = -prices[0] , zero = 0;
        for (int i = 1; i < prices.length; i++) {
            int lastOne = one;
            one = Math.max(zero - prices[i], one);
            zero = Math.max(lastOne + prices[i] - fee, zero);
        }
        return zero;
    }
}
