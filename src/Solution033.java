public class Solution033 {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<nums[right]){
                if(target<=nums[right]&&target>nums[mid]) left = mid + 1;
                else right = mid - 1;
            }else{
                if(target>=nums[left]&&target<nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }
}
