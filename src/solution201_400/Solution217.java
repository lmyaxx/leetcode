package solution201_400;

import java.util.HashSet;
import java.util.Set;

public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for(int num:nums){
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
