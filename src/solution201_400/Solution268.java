package solution201_400;

import java.math.BigInteger;

public class Solution268 {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i=0;i<nums.length;i++){
            res=res^i^nums[i];
        }
        return res;
    }
}
