package solution001_200;

public class Solution081 {
    public boolean search(int[] nums, int target) {
        int left = 0,right=nums.length-1;
        while(left<=right){
            int mid = (right+left)>>1;
            if(nums[mid]==target){
                return true;
            }else if(nums[mid]>nums[right]){
                if(target>=nums[left]&&target<nums[mid]) right=mid-1;
                else left=mid+1;
            }else if(nums[mid]<nums[right]){
                if(target>nums[mid]&&target<=nums[right]) left= mid+1;
                else right = mid-1;
            }else {
                right--;
            }
        }
        return false;
    }
}
