public class Solution031 {
    public void nextPermutation(int[] nums) {
        int len = nums.length,left=len-2,right=len-1;
        if(len<=1) return;
        //1,4,6,5,3 -> 1,5,6,4,3 -> 1,5,3,4,6
        while(left>=0&&nums[left]>=nums[left+1]) left--;
        if(left!=-1){
            right = left+1;
            while(right+1<len&&nums[left]<nums[right+1]) right++;
            nums[left]^=nums[right];
            nums[right]^=nums[left];
            nums[left]^=nums[right];
        }
        left = left+1;
        right = len -1;
        while(left<right){
            nums[left]^=nums[right];
            nums[right]^=nums[left];
            nums[left]^=nums[right];
            left++;right--;
        }
    }
}
