package solution401_600;

/**
 * @Author : Chad li
 * @Date : 2020/4/21 10:30
 * @Version 1.0
 */
public class Solution420 {
    public int strongPasswordChecker(String s) {
        char[] ss = s.toCharArray();
        int[] repeat = new int[ss.length];
        int digit = 0, lower = 0, upper = 0;
        int ans = 0;
        int miss = 3;
        for(int i=0;i<ss.length;i++){
            if(Character.isDigit(ss[i])){
                digit = 1;
            }
            if(Character.isUpperCase(ss[i])){
                upper = 1;
            }
            if(Character.isLowerCase(ss[i])){
                lower = 1;
            }
            if(i+2<ss.length&&ss[i]==ss[i+1]&&ss[i+1]==ss[i+2]){
                int len = 3;
                while(i+len<ss.length&&ss[i]==ss[i+len]){
                    len++;
                }
                repeat[i] = len;
                i = i + len - 1;
            }
        }
        miss -= digit + lower + upper;
        if(ss.length < 6){
            ans = Math.max(miss,6 - ss.length);
        }else{
            int toDelete = Math.max(ss.length-20,0), replace = 0;
            ans += toDelete;
            for(int i=0;i<repeat.length&&toDelete>0;i++){
                if(repeat[i]>=3){
                    if(repeat[i]%3==0){
                        repeat[i] -= 1;
                        toDelete -= 1;
                    }
                    if(repeat[i]%3==1&&toDelete>1){
                        repeat[i] -=2;
                        toDelete-=2;
                    }
                }
            }
            for(int i=0;i<repeat.length;i++){
                if(repeat[i]>=3&&toDelete>0){
                    int needToDelete = repeat[i] - 2;
                    repeat[i] -= toDelete;
                    toDelete -= needToDelete;
                }
                if(repeat[i]>=3){
                    replace += repeat[i]/3;
                }
            }
            ans += Math.max(miss,replace);
        }
        return ans;
    }
}
