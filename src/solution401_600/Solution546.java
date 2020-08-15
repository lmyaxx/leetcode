package solution401_600;

/**
 * @Author : Chad li
 * @Date : 2020/5/6 15:35
 * @Version 1.0
 */
public class Solution546 {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return  removeBoxesSub(boxes,0,n-1,0,dp);

    }

    //在 [i, j] 前已经有k个值和boxes[i] 相等
    private int removeBoxesSub(int[] boxes, int i, int j, int k, int[][][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j][k] > 0){
            return dp[i][j][k];
        }
        int res = 0;
        //统计 从左到右连续有多少个boxes[i];
        for(;i<j&&boxes[i]==boxes[i+1];i++,k++){

        }
        // 先移除区间[i+1, j]的盒子，再移除boxes[i]颜色的盒子
        res = (k+1)*(k+1) + removeBoxesSub(boxes,i+1,j,0,dp);

        //以boxes[i] 为起始， 对后面任意j>i, boxes[i] = boxes[j] 的区间[i,j]进行尝试
        for(int m=i+1;m<=j;m++){
            if(boxes[m]==boxes[i]){
                // 移除了boxes[i+1, mid]情况的得分
                res = Math.max(res,removeBoxesSub(boxes,i+1,m-1,0,dp)+removeBoxesSub(boxes,m,j,k+1,dp));
            }
        }
        dp[i][j][k] = res;
        return res;
    }
}
