package solution001_200;

public class Solution055 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len<=1) return true;
        int left=0,right=0;
        while(left<=right){
            int temp=right;
            for(;left<=temp;left++){
                right = Math.max(nums[left]+left,right);
            }
            if(right>=len-1) return true;
            if(right<=temp) return false;
        }
        return false;
    }
}
