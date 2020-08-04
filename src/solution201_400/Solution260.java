package solution201_400;

/**
 * @Author : Chad li
 * @Date : 2020/3/18 9:11
 * @Version 1.0
 */
public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int num:nums){
            diff ^= num;
        }
        diff &= (-diff);
        int[] res = new int[]{0,0};
        for(int num:nums){
            if((diff&num)==diff){
                res[0] ^=num;
            }else{
                res[1] ^=num;
            }
        }
        return res;
    }
}
