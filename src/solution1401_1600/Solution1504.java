package solution1401_1600;

import java.util.Stack;

public class Solution1504 {
    public int numSubmat(int[][] mat) {
        int res = 0;
        int rows = mat.length, cols = mat[0].length;
        while(rows>1){
            for(int i=0;i<rows; i++){
                res += count(mat[i]);
                if(i+1<rows){
                    for(int col = 0;col<cols;col++){
                        mat[i][col] &= mat[i+1][col];
                    }
                }

            }
            rows--;
        }
        res += count(mat[0]);
        return res;
    }

    private int count(int[] nums){
        int res = 0, begin = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                res += begin++;
            }else{
                begin = 1;
            }
        }
        return res;
    }


    public int numSubmat1(int[][] mat) {
        if(mat.length==0||mat[0].length==0){
            return 0;
        }
        int rows = mat.length, cols = mat[0].length;
        int[] heights = new int[cols];
        int ans = 0;
        for (int[] row : mat) {
            for (int col = 0; col < cols; col++) {
                heights[col] = row[col] == 0 ? 0 : heights[col] + 1;
            }
            ans += calculate(heights);
        }
        return ans;
    }
    private int calculate(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int[] sums = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                sums[i] = heights[i]*(i+1);
            }else{
                int preIndex = stack.peek();
                sums[i] = sums[preIndex];
                sums[i] += heights[i]*(i-preIndex);
            }
            stack.push(i);
        }
        int ans = 0;
        for(int num:sums){
            ans+=num;
        }
        return ans;
    }
}
