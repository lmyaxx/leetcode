package solution001_200;

public class Solution041 {
    public int firstMissingPositive(int[] nums) {
        if(nums ==null||nums.length==0) return 1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int num = nums[i];
            while(nums[i]<=n&&nums[i]>0&&nums[num-1] != num){
                nums[i] = nums[num-1];
                nums[num-1] =num;
                num = nums[i];
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i] != i+1) return i+1;
        }
        return n+1;
    }
}
