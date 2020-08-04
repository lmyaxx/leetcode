package solution001_200;

public class Solution169 {
    public int majorityElement(int[] nums) {
        int count=1,major = nums[0];
        for(int i=1;i<nums.length;i++){
            if(count==0){
                major=nums[i];
                count=1;
            }else if(nums[i]==major){
                count++;
            }else{
                count--;
            }
        }
        return major;
    }
}
