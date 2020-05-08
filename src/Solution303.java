import Common.NumArray;
import org.junit.Test;

/**
 * @Author : Chad li
 * @Date : 2020/5/8 10:32
 * @Version 1.0
 */
public class Solution303 {

    @Test
    public void test_Solution(){
        int[] nums = new int[]{1,2,3,5,7,3,-2};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0,4));
    }
}
