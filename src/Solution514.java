import java.util.*;

/**
 * @Author : Chad li
 * @Date : 2020/5/3 20:56
 * @Version 1.0
 */
public class Solution514 {
    public int findRotateSteps(String ring, String key) {
        int circle = ring.length();
        //dp[i].get(pos) means the minimum steps of the key.charAt(i) at pos
        Map<Integer,Integer>[] dp = new HashMap[key.length()+1];
        List<Integer>[] pos = new LinkedList[26];
        for(int i=0;i<pos.length;i++){
            pos[i] = new LinkedList<>();
        }
        for(int i=0;i<ring.length();i++){
            pos[ring.charAt(i)-'a'].add(i);
        }
        dp[0] = new HashMap<>();
        dp[0].put(0,0);
        for(int i=1;i<=key.length();i++){
            dp[i] = new HashMap<>();
            char ch = key.charAt(i-1);
            List<Integer> cur = pos[ch-'a'];
            Set<Map.Entry<Integer,Integer>> entrys = dp[i-1].entrySet();
            for(Integer opt: cur){
                for(Map.Entry<Integer,Integer> item:entrys){
                    int curValue = Math.min((opt-item.getKey()+circle)%circle , (item.getKey()-opt+circle)%circle) + item.getValue();
                    dp[i].put(opt,Math.min(dp[i].getOrDefault(opt,Integer.MAX_VALUE), curValue));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> entry:dp[key.length()].entrySet()){
            ans = Math.min(ans,entry.getValue());
        }
        return ans + key.length();
    }
}
