import java.util.HashSet;
import java.util.List;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length()];
        for(int i=0,len=s.length();i<len;i++){
            if(set.contains(s.substring(0,i+1))){
                dp[i]=true;
                continue;
            }
            for(int j=1;j<=i;j++){
                if(dp[j-1]&&set.contains(s.substring(j,i+1))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()-1];
    }
}
