public class Solution1025 {
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N+1];
        dp[1] = false;
        for(int i = 2; i <= N; i++){
            for(int j=1;j<i;j++){
                if(i%j==0&&dp[i-j]==false){
                    dp[i] = true;
                }
            }
        }
        return dp[N];
    }
    //奇数*奇数 = 奇数
    //奇数-奇数 = 偶数
    //所以拿到奇数得到的必是偶数
    //偶数可以-1还一个奇数
    public boolean divisorGame1(int N) {
        boolean[] dp = new boolean[N+1];
        dp[1] = false;
        for(int i = 2; i <= N; i++){
            for(int j=1;j<i;j++){
                if(i%j==0&&dp[i-j]==false){
                    dp[i] = true;
                }
            }
        }
        return dp[N];
    }
}
