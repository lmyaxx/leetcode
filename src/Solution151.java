import java.util.Arrays;

public class Solution151 {
    public String reverseWords(String s) {
        char [] str = new char[s.length()+1];
        int j=0;
        for(int i=s.length()-1;i>=0;i--){
            while(i>=0&&s.charAt(i)==' ')
                i--;
            int right=i;
            while(i>=0&&s.charAt(i)!=' '){
                i--;
            }
            int left=i;
            while(left<right){
                str[j++]=s.charAt(++left);
            }
            str[j++]=' ';
        }
        return String.valueOf(str).trim();
    }

}
