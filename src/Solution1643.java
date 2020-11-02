public class Solution1643 {
    public String kthSmallestPath(int[] destination, int k) {
        int rows = destination[0], cols = destination[1];
        int[][] dp = new int[rows+2][cols+2];
        dp[rows+1][cols] = 1;
        for(int r = rows; r>=0; r--){
            for(int c = cols; c >=0; c-- ){
                dp[r][c] = dp[r+1][c] + dp[r][c+1];
            }
        }
        StringBuilder ans = new StringBuilder();
        int r = 0, c = 0;
        while( c!=cols || r != rows){
            if(c-1<cols && dp[r][c+1]>=k){
                ans.append("H");
                c++;
            }else{
                ans.append("V");
                k -= dp[r][c+1];
                r++;
            }
        }
        return ans.toString();
    }
}
