package homework;

/**
 * 欠款问题
 * 最多有20个公司，最多发生1000笔交易
 * 求最少的交易次数
 */
public class Owe {

    // n is the number of companies
    public int getMinimumTransactions(int n,int[][] transactions){
        int[] companies = new int[n];
        for(int[] transaction:transactions){
            //transaction[1] owes transaction[0] transaction[2]
            companies[transaction[0]] += transaction[2];
            companies[transaction[1]] -= transaction[2];
        }
        int total = 1<<n;
        //dp[i] means the max counts of sub set whose sum is 0;
        int[] sum = new int[total];
        for(int i=0;i<total;i++){
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=1){
                    sum[i] += companies[j];
                }
            }
        }
        int[] dp = new int[total];
        for(int i=0;i<total;i++){
            for(int j=0;j<n;j++){
                if((i&(1<<j))==0){
                    int selected = i|1<<j;
                    dp[selected] = Math.max(dp[selected],dp[i]+(sum[selected]==0? 1:0));
                }
            }
        }
        return dp[total-1];
    }
}
