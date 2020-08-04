package solution001_200;

public class Solution080 {
    public int removeDuplicates(int[] nums) {
        int i=0,j=0,len=nums.length;
//      [0,0,1,1,1,1,2,3,3]
        while(j<len){
            nums[i++] = nums[j++];
            if(j<len&&nums[j]==nums[j-1]){
                nums[i++] = nums[j-1];
                while(j<len&&nums[j]==nums[j-1]){
                    j++;
                }
            }
        }
        return i;
    }
}
