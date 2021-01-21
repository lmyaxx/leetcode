package solution1401_1600;

import java.util.HashSet;

public class Solution1546 {
    public int maxNonOverlapping(int[] nums, int target) {
        int count = 0, sum = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(0);
        for(int i=0; i< nums.length ; i++){
            sum += nums[i];
            if(set.contains(sum - target)){
                count ++;
                set.clear();
                set.add(0);
                sum = 0;
            }else{
                set.add(sum);
            }
        }
        return count;
    }
}
