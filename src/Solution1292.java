public class Solution1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length, cols = mat[0].length;
        int[][] sum = new int[rows+1][cols+1];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                sum[i+1][j+1] += sum[i+1][j] + mat[i][j];
            }
            for(int j=0;j<cols;j++){
                sum[i+1][j+1] += sum[i][j+1];
            }
        }
        int max = Math.min(rows,cols);
        int res = 1;
        while(res<=max){
            boolean isValid = false;
            outer:for(int i=0;i+res-1<rows;i++){
                for(int j=0;j+res-1<cols;j++){
                    if(sum[i+res][j+res]-sum[i+res][j]-sum[i][j+res]+sum[i][j]<=threshold){
                        isValid = true;
                        break outer;
                    }
                }
            }
            if(!isValid){
                break;
            }
            res++;
        }
        return res - 1;

    }
}
