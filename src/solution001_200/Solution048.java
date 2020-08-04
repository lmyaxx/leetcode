package solution001_200;

public class Solution048 {
    public void rotate(int[][] matrix) {
        int len = matrix.length-1;
//         int top = matrix[i][j];
//         int down = matrix[len-i][len-j];
//         int right = matrix[j][len-i];
//         int left = matrix[len-j][i];

        for(int left=0,right=len;left<right;left++,right--){
            for(int row=left,col=left;col<right;col++){
                //right与top交换
                swap(matrix,col,len-row,row,col);
                //top与left交换
                swap(matrix,row,col,len-col,row);
                //left与down交换
                swap(matrix,len-col,row,len-row,len-col);
            }
        }
    }

    private void swap(int [][] matrix,int x1,int y1,int x2,int y2){
        matrix[x1][y1] ^=  matrix[x2][y2];
        matrix[x2][y2] ^=  matrix[x1][y1];
        matrix[x1][y1] ^=  matrix[x2][y2];
    }
}
