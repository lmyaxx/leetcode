/**
 * @Author : Chad li
 * @Date : 2020/3/11 14:37
 * @Version 1.0
 */
public class Solution214 {
    public String shortestPalindrome(String s) {
        StringBuilder sb1  = new StringBuilder(s);
        StringBuilder sb2  = new StringBuilder(s).reverse();
        int i = 0;
        while(sb1.length()!=0){
            if(sb1.toString().equals(sb2.toString())){
                break;
            }else{
                sb1.deleteCharAt(sb1.length()-1);
                sb2.deleteCharAt(0);
                i++;
            }
        }
        return new StringBuilder(s).reverse().substring(0,i) + s;
    }
}
