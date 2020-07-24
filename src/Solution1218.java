import java.util.HashMap;

public class Solution1218 {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int res = 0;
        for(int num:arr){
            map.put(num,map.getOrDefault(num-difference,0) + 1);
            res = Math.max(map.get(num),res);
        }
        return res;
    }
}
