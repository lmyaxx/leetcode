import java.util.HashMap;

/**
 * @Author : Chad li
 * @Date : 2020/2/27 15:51
 * @Version 1.0
 */
public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        HashMap<Integer,Integer> map  = new HashMap<>();
        map.put(0,1);
        for(int num:nums){
            sum += num;
            res += map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}
