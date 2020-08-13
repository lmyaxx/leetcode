package solution601_800;

import java.util.Arrays;

public class Solution0719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length ;
        int max  = nums[len - 1];
        int min = 0;
        while(min<=max){
            int mid = (min+max)/ 2;
            int count = 0;
            for(int j=0; j<nums.length; j++){
                int i = 0;
                while(i<j&&nums[j] - nums[i]> mid){
                    i++;
                }
                count += j - i;
                if(count>=k){
                    break;
                }
            }
            if(count>=k){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return max + 1;
    }
}
