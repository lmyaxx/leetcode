package solution001_200;

public class Solution115 {

    public int numDistinct(String s, String t) {
        if(s.length()==0||t.length()==0) return 0;
        int dp[][] = new int[t.length()+1][s.length()+1];
//        S = "rabbbit", T = "rabbit"
        for(int i=0;i<s.length();i++)
            dp[0][i]=1;
        for(int i=1;i<=t.length();i++){
            int j=i;
            while(j<=s.length()&&t.charAt(i-1)!=s.charAt(j-1)) j++;
            if(j>s.length()) return 0;
            else{
                dp[i][j] =dp[i-1][j-1]+dp[i][j-1];
            }
            j++;
            while(j<=s.length()){
                if(t.charAt(i-1)==s.charAt(j-1))
                    dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
                else dp[i][j]=dp[i][j-1];
                j++;
            }
        }
        return dp[t.length()][s.length()];
    }
}
