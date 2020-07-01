public class Solution718 {
    public int findLength(int[] A, int[] B) {
        if(A.length == 0||B.length == 0){
            return 0;
        }
        int[][] dp = new int[A.length+1][B.length+1];
        int res = 0;
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=B.length;j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res;
    }
}
