import java.util.Stack;

public class Solution020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char ch;
        for(int i=0,len=s.length();i<len;i++){
            ch = s.charAt(i);
            if(ch=='{'||ch=='['||ch=='('){
                stack.push(ch);
            }
            else{
                if(stack.empty()) return false;
                if(ch=='}'&&'{'!=stack.pop()) return false;
                if(ch==']'&&'['!=stack.pop()) return false;
                if(ch==')'&&'('!=stack.pop()) return false;
            }
        }
        return stack.empty();
    }
}
