package solution001_200;

public class Solution026 {
    public int removeDuplicates(int[] nums) {
        int len=nums.length,result=1;
        if(len==0) return 0;
        for(int i=0;i<len-1;i++){
            if(nums[i]!=nums[i+1]){
                result ++;
                nums[result]=nums[i+1];
            }
        }
        return result;
    }
}