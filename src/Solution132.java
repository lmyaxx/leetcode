import java.util.Queue;

public class Solution132 {
    public int minCut(String s) {
        boolean memo[][] = getMemo(s);
        int size = s.length();
        int dp[] = new int[size];
        dp[0] =0;
        for(int i=1;i<size;i++){
            dp[i] =dp[i-1]+1;
            for(int j=i-1;j>0;j--){
                if(memo[j][i]){
                    dp[i]=Math.min(dp[j-1]+1,dp[i]);
                }
            }
            if(memo[0][i]){
                dp[i]=0;
            }
        }
        for(int i:dp){
            System.out.print(i);
        }
        return dp[size-1];
    }

    private boolean[][] getMemo(String s){
        char str[] = s.toCharArray();
        int size = str.length;
        boolean memo[][] = new boolean[size][size];
        for(int i=size-1;i>=0;i--){
            for(int j=i;j<size;j++){
                if(i==j){
                    memo[i][j]=true;
                    continue;
                }
                if(i==j-1&&str[i]==str[j]){
                    memo[i][j]=true;
                    continue;
                }
                if(str[i]==str[j]&&memo[i+1][j-1])
                    memo[i][j]=true;
            }
        }
        return memo;
    }
}
