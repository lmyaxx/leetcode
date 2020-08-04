package solution001_200;

import java.util.Arrays;

public class Solution034 {
    public int[] searchRange(int[] nums, int target) {
        int right = nums.length -1,left=0;
        int result[] = {-1,-1};
        while(left<=right){
            int mid = (left+right)/2;
            if(target>=nums[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        if(right==-1||nums[right]!=target)
            return result;
        else{
            result[1] = right;
            right = nums.length -1;left=0;
            while(left<=right){
                int mid = (left+right)/2;
                if(target<=nums[mid]){
                    right = mid -1;
                }else{
                    left = mid+1;
                }
            }
            result[0] = left;
        }
        return result;
    }
}
