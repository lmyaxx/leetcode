/**
 * @Author : Chad li
 * @Date : 2020/1/4 19:05
 * @Version 1.0
 */
public class Solution329 {
    //8 1000: self is higher than the left part, lower than others
    //4 0100: self is higher than the top part, lower than others
    //2 0010: self is higher than the right part, lower than others
    //1 0001: self is higher than the down part, lower than others
    // the area outside is higher than than inside
    private int[][] getHelpMatrix(int [][] matrix){
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] helpMatrix = new int[height][width];
        for(int row = 0; row < height;row++){
            for(int col=0;col<width;col++){
                helpMatrix[row][col] = isHigherThanNeighbors(matrix,row,col);
            }
        }
        return helpMatrix;
    }

    private int isHigherThanNeighbors(int[][]matrix ,int row, int col){
        int result = 0b0000;
        if(col>=1){
            if(matrix[row][col]>matrix[row][col-1]){
                result |= 0b1000;
            }
        }
        if(row>=1){
            if(matrix[row][col]>matrix[row-1][col]){
                result |= 0b0100;
            }
        }
        if(col<matrix[0].length - 1){
            if(matrix[row][col]>matrix[row][col+1]){
                result |= 0b0010;
            }
        }
        if(row<matrix.length - 1){
            if(matrix[row][col]>matrix[row+1][col]){
                result |= 0b0001;
            }
        }
        return result;
    }

    //because it is in descending order ,there will not be a circle
    private int getMaxHeightFor(int[][]heightMatrix,int[][] helpMatrix, int row, int col){
        if(heightMatrix[row][col] !=0){
            return heightMatrix[row][col];
        }else{
            int result = 1;
            if((helpMatrix[row][col] & 0b1000) == 0b1000){
                result = Math.max(result, getMaxHeightFor(heightMatrix,helpMatrix,row,col-1) + 1);
            }
            if((helpMatrix[row][col] & 0b0100) == 0b0100){
                result = Math.max(result, getMaxHeightFor(heightMatrix,helpMatrix,row-1,col) +1);
            }
            if((helpMatrix[row][col] & 0b0010) == 0b0010){
                result = Math.max(result, getMaxHeightFor(heightMatrix,helpMatrix,row,col+1)+1);
            }
            if((helpMatrix[row][col] & 0b0001) == 0b0001){
                result = Math.max(result, getMaxHeightFor(heightMatrix,helpMatrix,row+1,col)+1);
            }
            heightMatrix[row][col] = result;
            return heightMatrix[row][col];
        }
    }

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length ==0){
            return 0;
        }
        int result = 0;
        int [][] helpMatrix = getHelpMatrix(matrix);
        int [][] heightMatrix = new int[matrix.length][matrix[0].length];
        for(int row =0; row<matrix.length; row ++){
            for(int col=0;col<matrix[0].length; col++){
//                System.out.print(" " + helpMatrix[row][col]);
                result = Math.max(result,getMaxHeightFor(heightMatrix,helpMatrix,row,col));
            }
//            System.out.println();
        }
        return result;
    }
}
