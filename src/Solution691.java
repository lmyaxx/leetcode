import java.util.HashMap;
import java.util.Map;

public class Solution691 {
    public int minStickers(String[] stickers, String target) {
        int[][] dp = new int[stickers.length][26];
        for(int i=0;i<stickers.length;i++){
            for (char ch: stickers[i].toCharArray()) {
                dp[i][ch-'a']++;
            }
        }
        Map<String, Integer> res = new HashMap<>();
        res.put("",0);
        return helper(dp,res,target);
    }

    private int helper(int[][] dp, Map<String, Integer> res, String target) {
        if(res.containsKey(target)){
            return res.get(target);
        }
        int ans = Integer.MAX_VALUE;
        int[] status = new int[26];
        for(char ch:target.toCharArray()){
            status[ch-'a'] ++;
        }
        for(int i=0;i<dp.length;i++){
            // optimization
            if (dp[i][target.charAt(0)-'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            for(int k=0;k<26;k++){
                int rest = Math.max(0,status[k]-dp[i][k]);
                for(int c = 0;c<rest;c++){
                    sb.append((char)('a' + k));
                }
            }
            int temp =helper(dp,res,sb.toString());
            if(temp!=-1){
                ans = Math.min(ans,temp+1);
            }
        }
        res.put(target,ans==Integer.MAX_VALUE?-1:ans);
        return res.get(target);
    }
}
