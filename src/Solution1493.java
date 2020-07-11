public class Solution1493 {
    public int longestSubarray(int[] nums) {
        int[] left = new int [nums.length];
        int[] right = new int [nums.length];
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==1){
                left[i] = left[i-1] + 1;
            }else{
                left[i] = 0;
            }
        }
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i+1]==1){
                right[i] = right[i+1] + 1;
            }else{
                right[i] = 0;
            }
        }
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            ans = Math.max(left[i]+right[i],ans);
        }
        return ans;
    }
}
