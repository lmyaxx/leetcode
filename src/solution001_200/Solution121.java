package solution001_200;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE,res=0;
        for(int i=0;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            res =  Math.max(prices[i]-min,res);
        }
        return res;
    }
}
