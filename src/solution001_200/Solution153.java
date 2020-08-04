package solution001_200;

public class Solution153 {
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]<nums[right]){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return nums[left];
    }
}
