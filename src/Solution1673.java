import java.util.Deque;
import java.util.Stack;

public class Solution1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++){
            while(stack.size() + nums.length - i >k && !stack.isEmpty()&&stack.peek() > nums[i]){
                stack.pop();
            }
            if(stack.size()<k){
                stack.push(nums[i]);
            }
        }
        int[] ans = new int[k];
        for(int i = k-1; i>=0 ; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}
