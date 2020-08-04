package solution201_400;

/**
 * @Author : Chad li
 * @Date : 2020/3/29 20:08
 * @Version 1.0
 */
public class Solution330 {
    public int minPatches(int[] nums, int n) {
        long missed = 1;
        int count=0,i=0;
        while(missed<=n){
            if(i<nums.length&&nums[i]<=missed){
                missed += nums[i++];
            }else{
                count++;
                missed += missed;
            }
        }
        return count;
    }

}
