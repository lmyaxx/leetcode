package Common;

/**
 * @Author : Chad li
 * @Date : 2020/5/8 10:33
 * @Version 1.0
 */
public class NumArray {


    private long[] pre;

    public NumArray(int[] nums) {
        pre = new long[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            pre[i] += nums[i-1] + pre[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return (int)(pre[j+1] - pre[i]);
    }
}
