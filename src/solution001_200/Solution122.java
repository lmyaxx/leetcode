package solution001_200;

public class Solution122 {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int sum=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1])
                sum+=prices[i]-prices[i-1];
        }
        return sum;
    }
}
