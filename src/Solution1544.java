import java.util.Stack;

public class Solution1544 {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack();
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty()&& Math.abs(stack.peek()-ch)==32){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        int n = stack.size();
        char[] ans = new char[n];
        while(n-->0){
            ans[n] = stack.pop();
        }
        return new String(ans);
    }
}
