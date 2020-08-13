package solution601_800;

public class Solution664 {
    public int strangePrinter(String s) {
        if("".equals(s)){
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int width = 1; width<=len; width++) {
            int left = 0, right = width-1;
            while(right<len){
                dp[left][right] = Integer.MAX_VALUE;
                if(left==right){
                    dp[left][right] = 1;
                }
                for(int k = left;k<right;k++){
                    if(s.charAt(k)==s.charAt(right)){
                        dp[left][right] = Math.min(dp[left][right],dp[left][k] + dp[k+1][right-1]);
                    }else{
                        dp[left][right] = Math.min(dp[left][right],dp[left][k] + dp[k+1][right]);
                    }
                }
                left++;
                right++;
            }
        }
        return dp[len-1][len-1];
    }
}
