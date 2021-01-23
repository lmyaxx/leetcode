package solution801_1000;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author: chad li
 * @date: 2021/1/23
 * @discription:
 */
public class Solution0946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = popped.length;
        int level = -1;
        HashMap<Integer,Integer> valToIdx = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< pushed.length ;i ++){
            valToIdx.put(pushed[i], i);
        }
        for(int num : popped){
            if(!stack.isEmpty()&&stack.peek().equals(num)){
                stack.pop();
                continue;
            }
            Integer idx = valToIdx.get(num);
            if(idx == null){
                return false;
            }
            if(idx<=level){
                return false;
            }else{
                while(level<idx){
                    stack.push(pushed[level+1]);
                    level++;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
