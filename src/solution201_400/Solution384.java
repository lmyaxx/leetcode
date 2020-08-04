package solution201_400;

import java.util.Random;

/**
 * @Author : Chad li
 * @Date : 2020/1/19 21:18
 * @Version 1.0
 */
public class Solution384 {

    private int[] nums;
    private Random random;

    public Solution384(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[]a =  nums.clone();
        for(int j=1;j<a.length;j++){
            swap(a,random.nextInt(j+1),j);
        }
        return a;
    }

    private void swap(int[] list,int x,int y){
        int temp = list[x];
        list[x] = list[y];
        list[y] = temp;
    }
}
