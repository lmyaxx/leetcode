package solution001_200;

import java.util.Arrays;
import java.util.HashSet;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result =0;
        for(int num:nums){
            set.add(num);
        }
        while (!set.isEmpty()){
            int root=0,count=1;
            for(Integer one:set){
                root = one;
                break;
            }
            set.remove(root);
            int left=root-1,right=root+1;
            while(set.remove(left--)) count++;
            while(set.remove(right++)) count++;
            result = Math.max(result,count);
        }
        return result;
    }
}
