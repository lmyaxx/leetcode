package solution201_400;

public class Solution227 {
    public int calculate(String s) {
        char[] str = s.toCharArray();
        int len = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ') {
                str[len++] = str[i];
            }
        }
        int result = 0, right, left = 0;
        char sign = ' ', last = '+';
        int i = 0;
        while (i < len && Character.isDigit(str[i])) {
            left = left * 10 + (str[i] - '0');
            i++;
        }
        while (i < len) {
            if (i < s.length()) {
                sign = str[i];
                i++;
            }
            right = 0;
            while (i < len && Character.isDigit(str[i])) {
                right = right * 10 + (str[i] - '0');
                i++;
            }
//            System.out.println("sign:" + sign + " left：" + left + " right:" + right + "result:" + result);
            if(sign=='+'||sign=='-'){
                result = helper(result,left,last);
                left = right;
                last = sign;
            }
            if(sign=='*'||sign=='/'){
                left = helper(left,right,sign);
            }
        }
        return helper(result ,left,last);
    }

    private int helper(int left,int right,char sign){
        switch (sign){
            case '+':return left+right;
            case '-':return left-right;
            case '*':return left*right;
            case '/':return left/right;
        }
        return 0;
    }
}
