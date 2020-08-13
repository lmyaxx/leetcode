package solution601_800;

import java.util.Stack;

/**
 * @Author : Chad li
 * @Date : 2020/2/28 16:33
 * @Version 1.0
 */
public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(T.length -1);
        for(int i = res.length - 2; i>=0;i--){
            while(!stack.isEmpty() &&T[i] >= T[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = 0;
            } else{
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
}
