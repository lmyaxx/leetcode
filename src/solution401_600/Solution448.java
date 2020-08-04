package solution401_600;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Chad li
 * @Date : 2020/2/27 10:28
 * @Version 1.0
 */
public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0;i<nums.length; i++){
            int k = nums[i];
            while(k>0){
                int temp = nums[k -1];
                nums[k - 1] = -1;
                k = temp;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length;i++){
            if(nums[i] >0 ){
                res.add(i+1);
            }
        }
        return res;
    }
}
