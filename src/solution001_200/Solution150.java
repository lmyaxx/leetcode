package solution001_200;

import java.util.Stack;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("*")){
                Integer cur = stack.pop();
                cur=stack.pop() * cur;
                stack.push(cur);
                continue;
            }
            if(tokens[i].equals("/")){
                Integer cur = stack.pop();
                cur=stack.pop() / cur;
                stack.push(cur);
                continue;
            }
            if(tokens[i].equals("+")){
                Integer cur = stack.pop();
                cur=stack.pop() + cur;
                stack.push(cur);
                continue;
            }
            if(tokens[i].equals("-")){
                Integer cur = stack.pop();
                cur=stack.pop() - cur;
                stack.push(cur);
                continue;
            }
            stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }
}
