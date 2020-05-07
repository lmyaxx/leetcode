/**
 * @Author : Chad li
 * @Date : 2020/5/6 15:35
 * @Version 1.0
 */
public class Solution546 {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return removeBoxesSub(boxes, 0, n - 1, 0, dp);
    }

    private int removeBoxesSub(int[] boxes, int i, int j, int k, int[][][] dp) {
        if(i>j){
            return 0;
        }
        if(dp[i][j][k]>0){
            return dp[i][j][k];
        }
        int res = 0;
        for(;i<j&&boxes[i]==boxes[i+1];i++,k++){

        }
        res = (k+1)*(k+1) + removeBoxesSub(boxes,i+1,j,0,dp);
        for(int m=i+1;m<=j;m++){
            if(boxes[m]==boxes[i]){
                res = Math.max(res,removeBoxesSub(boxes,m,j,k+1,dp)+removeBoxesSub(boxes,i+1,m-1,0,dp));
            }
        }
        dp[i][j][k] = res;
        return res;
    }
}
