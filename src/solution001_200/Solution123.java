package solution001_200;

public class Solution123 {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int right[] = new int[prices.length];
        int left[] = new int[prices.length];
        int temp=Integer.MAX_VALUE,profit=0,res=0;
        for(int i=0;i<prices.length;i++){
            temp=Math.min(prices[i],temp);
            profit=Math.max(profit,prices[i]-temp);
            left[i]=profit;
        }
        temp = Integer.MIN_VALUE;
        profit=0;
        for(int i=prices.length-1;i>=0;i--){
            temp=Math.max(prices[i],temp);
            profit = Math.max(temp-prices[i],profit);
            right[i]=profit;
            res=Math.max(left[i]+right[i],res);
        }
        return res;
    }

    public int maxProfit1(int []prices){
        int oneBuy = Integer.MAX_VALUE;
        int twoBuy = Integer.MAX_VALUE;
        int oneSell = 0;
        int twoSell = 0;
        for(int cur:prices){
            oneBuy = Math.min(cur,oneBuy);
            oneSell = Math.max(oneSell,cur-oneBuy);
            twoBuy = Math.min(twoBuy,cur-oneSell);
            twoSell = Math.max(twoSell,cur-twoBuy);
        }
        return twoSell;
    }
}
