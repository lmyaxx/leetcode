package solution001_200;

public class Solution053 {
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int result=Integer.MIN_VALUE,cul=0;
        for(int i=0;i<nums.length;i++){
            if(cul<0){
                cul = nums[i];
            }else{
                cul+=nums[i];
            }
            result = Math.max(cul,result);
        }
        return result;
    }
}
