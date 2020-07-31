package interview;

public class Solution0803 {
    public int findMagicIndex(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    private int helper(int[] nums, int start, int end){
        if(start>end||nums[start]>end||nums[end]<start){
            return -1;
        }
        int mid = (start + end) / 2;
        if(mid==nums[mid]){
            return mid;
        }
        int res = helper(nums,start,mid-1);
        if(res!=-1){
            return res;
        }
        res = helper(nums,mid+1,end);
        if(res!=-1){
            return res;
        }
        return res;
    }
}
