/**
 * @Author : Chad li
 * @Date : 2020/2/5 16:38
 * @Version 1.0
 */
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int height = matrix.length, width = matrix[0].length;
        int max=0;
        int [][]dp = new int[height+1][width+1];
        for(int i=0; i<height;i++){
            for(int j=0;j<width;j++){
                if(matrix[i][j]=='1'){
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i][j]) + 1;
                    max = Math.max(max,dp[i+1][j+1]);
                }
            }
        }
        return max*max;
    }
}
