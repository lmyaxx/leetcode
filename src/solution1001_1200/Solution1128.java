package solution1001_1200;

import java.util.HashMap;

/**
 * @author: chad li
 * @date: 2021/1/26
 * @discription:
 */
public class Solution1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String,Integer> count = new HashMap<>();
        for(int[] domino : dominoes ){
            String key = Math.min(domino[0],domino[1]) + "," + Math.max(domino[0],domino[1]);
            count.put(key, count.getOrDefault(key,0) + 1);
        }
        int ans = 0;
        for(int val : count.values()){
            ans += val * (val - 1) / 2;
        }
        return ans;
    }
}
