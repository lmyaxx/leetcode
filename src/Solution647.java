import java.util.Arrays;

/**
 * @Author : Chad li
 * @Date : 2020/2/28 17:02
 * @Version 1.0
 */
public class Solution647 {
    public int countSubstrings(String s) {
        if(s == null|| s.length()<1){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        sb.deleteCharAt(sb.length()-1);
        int center = 0;
        int[] radius = new int[s.length()*2-1];
        int res = 0;
        for(int i=0; i<sb.length(); i++){
            int border = center + radius[center] - 1;
            if(i <= border){
                //the symmetric point of i  is center - (i - center)
                radius[i] =  Math.min(border - i +1, radius[2*center-i]);
            }
            while(i+radius[i] <sb.length()&& i - radius[i] >=0 && sb.charAt(i+radius[i]) == sb.charAt(i-radius[i])){
                radius[i] ++;
            }
            // update the center
            if(i + radius[i] - 1 > border){
                center = i;
            }
            if( (i&1) == 1){
                res += radius[i]/ 2;
            } else{
                res += (radius[i] + 1) /2;
            }
        }
        return res;
    }

    private int countSubstrings1(String s){
        if(s==null|| s.length()<=0) {
            return 0;
        }
        int res = 0, end = s.length() - 1;
        boolean[][] dp = new boolean[end+1][end+1];
        for(int i=end;i>=0;i--){
            for(int j=i; j<=end;j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i<3||dp[i+1][j-1]);
                if(dp[i][j]){
                    res++;
                }
            }
        }
        return res;
    }
}
