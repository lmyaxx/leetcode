package solution601_800;

/**
 * @author: chad li
 * @date: 2021/1/28
 * @discription:
 */
public class Solution0724 {
    public int pivotIndex(int[] nums) {
        int sum = 0, left = 0;
        for(int num: nums){
            sum += num;
        }
        for(int i = 0; i<nums.length; i++){
            if(sum - left - nums[i] == left){
                return i;
            }else{
                left += nums[i];
            }
        }
        return -1;
    }
}
