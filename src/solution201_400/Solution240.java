package solution201_400;

import java.util.Arrays;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        int left=0,top=0,right=matrix[0].length-1,down = matrix.length-1;
        //get the right border, nums[right]<target<nums[left]
        while(left<=right){
            int mid =(left+right)/2;
            if(matrix[0][mid]==target)
                return true;
            else if(matrix[0][mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        int fixed_right = right;
        System.out.println("right:"+fixed_right);
        if(fixed_right==-1) return false;
        // get the down border
        while(top<=down){
            int mid =(top+down)/2;
            if(matrix[mid][0]==target)
                return true;
            else if(matrix[mid][0]<target){
                top=mid+1;
            }else{
                down = mid-1;
            }
        }
        int fixed_down = down;
        System.out.println("down:"+fixed_down);
        if(fixed_down==-1) return false;
        top=0;
        while(top<=down){
            int mid=(top+down)/2;
            if(matrix[mid][fixed_right]==target)
                return true;
            else if(matrix[mid][fixed_right]>target){
                down=mid-1;
            }else{
                top=mid+1;
            }
        }
        int fixed_top = top;
        System.out.println("top:" + fixed_top);
        for(int row=fixed_top;row<=fixed_down;row++){
            if(Arrays.binarySearch(matrix[row],0,fixed_right+1,target)>=0)
                return true;
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        int right = matrix[0].length,down = matrix.length;
        int left=right-1,top=0;
        while(left>=0&&top<down){
            if(matrix[top][left]<target){
                top++;
            }else if(matrix[top][left]>target) {
                left--;
            }else
                return true;
        }
        return false;
    }
}
