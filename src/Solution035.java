public class Solution035 {
    public int searchInsert(int[] nums, int target) {
        int right = nums.length -1 , left = 0;
        while(left<=right){
            int mid = (right+left)/2;
            if(target<=nums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
