package solution601_800;

import java.util.HashMap;
import java.util.Map;

public class Solution639 {
    public int numDecodings(String s) {
        int len = s.length();
        char[] str = s.toCharArray();
        long[] dp = new long[len+1];
        dp[1] = dp[0] = 1;
        if(str[0]=='*'){
            dp[1] = 9;
        }
        if(str[0]=='0'){
            dp[1] = 0;
        }
        int alone = 1;
        int together = 1;
        int mod =  1000000007;
        for(int i=1;i<len;i++){
            alone = getChoice(str[i] +"");
            together = getChoice(str[i-1] + "" + str[i]);
            dp[i+1] = ((dp[i] * alone % mod) + (dp[i-1] * together) % mod)%mod;
        }
        return (int)dp[len];
    }
    private int getChoice(String str){
        if(str.length()==1){
            if("*".equals(str)){
                return 9;
            }
            if("0".equals(str)){
                return 0;
            }
            return 1;
        }
        char pre = str.charAt(0), post = str.charAt(1);
        if(pre=='*'){
            if(post=='*'){
                return 15;
            }
            if(post>='0'&&post<='6'){
                return 2;
            }
            return 1;
        }
        if(pre=='1'){
            if(post=='*'){
                return 9;
            }
            return 1;
        }
        if(pre=='2'){
            if(post=='*'){
                return 6;
            }
            if(post>'6'){
                return 0;
            }
            return 1;
        }
        return 0;
    }
}
