package solution001_200;

import java.util.ArrayList;
import java.util.List;

public class Solution054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return new ArrayList<>();
        int left=0,top=0,right=matrix[0].length-1,down=matrix.length-1,count=(right+1)*(down+1);
        List<Integer> result = new ArrayList<>();
        int row=0,col=-1;
        while(count>0){
            while(count>0&&++col<=right) {result.add(matrix[row][col]);count--;}
            col--;top++;
            while(count>0&&++row<=down) {result.add(matrix[row][col]);count--;}
            row--;right--;
            while(count>0&&--col>=left) {result.add(matrix[row][col]);count--;}
            col++;down--;
            while(count>0&&--row>=top) {result.add(matrix[row][col]);count--;}
            row++;left++;
        }
        return result;
    }
}
