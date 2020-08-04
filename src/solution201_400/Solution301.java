package solution201_400;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Chad li
 * @Date : 2020/2/10 9:56
 * @Version 1.0
 */
public class Solution301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        helper(s,result,0,0,'(',')');
        return result;
    }

    private void helper(String s,List<String> result, int iStart, int jStart, char openParen, char closedParen){
        int openParenNum = 0;
        int closedParenNum = 0;
        for(int i=iStart;i<s.length();i++){
            if(s.charAt(i)== openParen) {
                openParenNum++;
            }
            if(s.charAt(i)==closedParen){
                closedParenNum++;
            }
            if(closedParenNum>openParenNum){
                for(int j=jStart;j<=i;j++){
                    if(s.charAt(j)==closedParen&&(j==jStart||s.charAt(j-1)!=closedParen)){
                        helper(s.substring(0,j)+s.substring(j+1,s.length()),result,i,j,openParen,closedParen);
                    }
                }
                return ;
            }
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(openParen =='('){
            helper(reversed,result,0,0,closedParen,openParen);
        }else{
            result.add(reversed);
        }
    }
}
