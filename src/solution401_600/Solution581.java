package solution401_600;

import java.util.Arrays;

/**
 * @Author : Chad li
 * @Date : 2020/2/27 16:08
 * @Version 1.0
 */
public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums,nums.length);
        Arrays.sort(copy);
        int start = 0,end = nums.length -1;
        while(start<nums.length&&copy[start]==nums[start]){
            start++;
        }
        while(end>=0&&copy[end] == nums[end]){
            end--;
        }
        if(end<=start){
            return 0;
        }
        return end -start + 1;

    }

    public int findUnsortedSubarray1(int[] nums){
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, end = -2, start = -1;
        for(int i=0;i<nums.length;i++){
            min = Math.min(min, nums[nums.length-i-1]);
            max = Math.max(max,nums[i]);
            if(nums[nums.length-i-1]>min){
                start = nums.length-i-1;
            }
            if(nums[i]<max){
                end = i;
            }
        }
        return end - start + 1;
    }
}
