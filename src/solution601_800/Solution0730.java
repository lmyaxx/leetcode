package solution601_800;

public class Solution0730 {
    int mod = 1000_000_007;

    public int countPalindromicSubsequences(String S) {
        int len = S.length();
        int[][] dp = new int[len][len];
        char[] str=  S.toCharArray();
        for(int width = 1; width <= len ; width++){
            for(int s = 0, e = s + width - 1; e < len; s++, e++){
                if(width==1){
                    dp[s][e] = 1;
                    continue;
                }
                if(str[s] != str[e]){
                    dp[s][e] = dp[s+1][e] + dp[s][e-1] - dp[s+1][e-1];
                }else{
                    int l = s + 1, r = e - 1;
                    while(l<=r && str[l] != str[s]){
                        l++;
                    }
                    while(s<=r && str[r] != str[e]){
                        r--;
                    }
                    int extra = l < r ? -dp[l+1][r-1] : l == r ? 1 : 2;
                    dp[s][e] = 2 * dp[s+1][e-1] + extra;
                }
                dp[s][e] = Math.floorMod(dp[s][e],mod);
            }
        }
        return dp[0][len-1];
    }
}
