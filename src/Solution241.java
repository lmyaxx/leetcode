import java.util.*;

/**
 * @Author : Chad li
 * @Date : 2020/3/15 11:41
 * @Version 1.0
 */
public class Solution241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input==null||"".equals(input)){
            return res;
        }
        boolean isNumber = true;
        for(int i=0;i<input.length();i++){
            if(!Character.isDigit(input.charAt(i))){
                isNumber = false;
                 List<Integer> left = diffWaysToCompute(input.substring(0,i));
                 List<Integer> right = diffWaysToCompute(input.substring(i+1));
                 for(int num1:left){
                     for(int num2:right){
                         res.add(compute(num1, num2, input.charAt(i)));
                     }
                 }
            }
        }
        if(isNumber){
            res.add(Integer.valueOf(input));
        }
        Collections.sort(res);
        return res;
    }
    private int compute(int left, int right, char operation){
        if(operation == '+'){
            return left + right;
        }
        if(operation== '-'){
            return left -right;
        }
        return left*right;
    }
}
