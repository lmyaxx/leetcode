import java.util.Arrays;

public class Solution016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len=nums.length;
        int result=nums[0]+nums[1]+nums[2];
        for(int i=0;i<len;i++){
            int j=i+1,k=len-1;
            for(;j<k;){
                int sum = nums[i]+nums[j] + nums[k];
                if(sum>target){
                    k--;
                }
                else if(sum<target) {
                    j++;
                }
                else return target;
                result=Math.abs(sum-target)<Math.abs(result-target)? sum : result;
            }

        }
        return result;
    }
}
