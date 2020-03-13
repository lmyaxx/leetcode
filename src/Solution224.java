import java.util.Stack;

/**
 * @Author : Chad li
 * @Date : 2020/3/13 10:59
 * @Version 1.0
 */
public class Solution224 {
    public int calculate(String s) {
        boolean newLevel = false;
        Stack<Integer> nums = new Stack<>();
        nums.push(0);
        Stack<Character>  operator = new Stack<>();
        operator.push('+');
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==' '){
                continue;
            }
            if(ch=='+'||ch=='-'){
                operator.push(ch);
                continue;
            }
            if(ch == '('){
                newLevel = true;
                continue;
            }
            if(ch == ')'){
                newLevel =false;
                int cur = nums.pop();
                if(nums.isEmpty()){
                    nums.push(cur);
                }else{
                    nums.push(compute(nums.pop(),cur,operator.pop()));
                }
                continue;
            }
            int num = ch - '0';
            while(i+1<s.length()&&s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'){
                num = num*10 + s.charAt(++i)- '0';
            }
            if(newLevel){
                newLevel = false;
                nums.push(num);
            }else{
                nums.push(compute(nums.pop(),num,operator.pop()));
            }
        }
        return nums.pop();
    }

    private int compute(int a, int b, char sign){
        if(sign=='+'){
            return a+b;
        }else{
            return a-b;
        }
    }

    public static int calculate1(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }

        }
        return result;
    }
}
