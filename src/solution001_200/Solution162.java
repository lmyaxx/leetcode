package solution001_200;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                continue;
            }else{
                return i-1;
            }
        }
        return nums.length-1;
    }
}
