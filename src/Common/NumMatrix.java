package Common;

/**
 * @Author : Chad li
 * @Date : 2020/5/8 10:47
 * @Version 1.0
 */
public class NumMatrix {

    private long[][] pre;

    public NumMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return;
        }
        int height = matrix.length, width = matrix[0].length;
        pre = new long[height+1][width+1];
        for(int row=1;row<=height;row++){
            for(int col=1;col<=width;col++){
                pre[row][col] = pre[row-1][col] + pre[row][col-1] - pre[row-1][col-1] + matrix[row-1][col-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int r1 = Math.min(row1,row2), r2 = Math.max(row1,row2);
        int c1 = Math.min(col1,col2), c2 = Math.max(col1,col2);
        return (int)(pre[r2+1][c2+1] - pre[r2+1][c1] - pre[r1][c2+1] + pre[r1][c1]);
    }
}
