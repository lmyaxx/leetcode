package solution401_600;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author : Chad li
 * @Date : 2020/2/27 11:52
 * @Version 1.0
 */
public class Solution494 {
    public int findTargetSumWays(int[] nums, int S) {
       int start = 0, end = nums.length -1;
       Map<Integer,Integer> bottom = new HashMap<>();
        Map<Integer,Integer> top = new HashMap<>();
        bottom.put(0,1);
        top.put(S,1);
       while(start<=end){
           if(bottom.size()<top.size()){
               bottom = helper(bottom, nums[start++]);
           } else {
               top = helper(top, nums[end--]);
           }
       }
       Set<Integer> sum = bottom.keySet();
       int res = 0;
       for(Integer key :  sum){
           if(top.containsKey(key)){
               res += top.get(key) * bottom.get(key);
           }
       }
       return res;
    }

    private Map<Integer,Integer> helper(Map<Integer, Integer> map, int num){
        Map<Integer,Integer> map1 = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            map1.put(entry.getKey() + num,entry.getValue() +  map1.getOrDefault(entry.getKey() + num,0));
            map1.put(entry.getKey() - num,entry.getValue() -  map1.getOrDefault(entry.getKey() + num,0));
        }
        return map1;
    }
    // sum(p) + sum(n) = sum(nums)
    // sum(p) - sum(n) = target
    // sum(p) = (sum(nums)  + target) / 2;
    public int findTargetSumWays1(int[] nums, int S) {
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        return sum<S||(sum + S) % 2 == 1 ? 0 : findTargetSum(nums,(sum+S)/2);
    }

    private int findTargetSum(int[] nums, int sum){
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for(int num:nums){
            for(int i = sum; i>=num; i--){
                dp[i] += dp[i-num];
            }
        }
        return dp[sum];
    }
}
