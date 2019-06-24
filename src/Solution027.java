public class Solution027 {
    public int removeElement(int[] nums, int val) {
        int len=nums.length,count=0;
        for(int i=0;i<len;i++){
            if(nums[i]!=val)
                nums[count++]=nums[i];
        }
        return count;
    }
}
