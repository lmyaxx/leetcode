package solution001_200;

public class Solution074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int width = matrix[0].length,right=width*matrix.length-1,left=0;
        while(left<=right){
            int mid = (left+right)/2;
            if(matrix[mid/width][mid%width]<=target) left=mid+1;
            else right=mid-1;
        }
        if(left<0)
            return false;
        return matrix[left/width][left%width] == target;
    }
}
