package solution201_400;

public class Solution287 {
    public int findDuplicate(int[] nums) {
        if(nums.length==0) return -1;
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow!=fast){
            slow = nums[slow];
            fast=nums[nums[fast]];
        }
        // why the fast should not be initialized as nums[0]
        // cause the slow is the end of the last circle
        fast = 0;
        while(slow!=fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
