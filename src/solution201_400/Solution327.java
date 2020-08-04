package solution201_400;

import java.util.Arrays;

/**
 * @Author : Chad li
 * @Date : 2020/3/28 15:29
 * @Version 1.0
 */
public class Solution327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums.length==0){
            return 0;
        }
        return countRangeSumSub(nums,0,nums.length-1,lower,upper);
    }


    private int countRangeSumSub(int[] nums, int left, int right, int lower, int upper){
        if(left==right){
            return nums[left]>=lower&&nums[right]<=upper ? 1:0;
        }
        int mid = (left+right)/2;
        long[] arr = new long[right-mid];
        long sum = 0;
        int count =0;
        for(int i = mid+1;i<=right;i++){
            sum+=nums[i];
            arr[i-(mid+1)] = sum;
        }
        Arrays.sort(arr);
        sum = 0;
        for(int i=mid;i>=left;i--){
            sum += nums[i];
            count += findIndex(arr,upper-sum+0.5)-findIndex(arr,lower-sum-0.5);
        }
        return countRangeSumSub(nums, left, mid, lower, upper) + countRangeSumSub(nums, mid + 1, right, lower, upper) + count;
    }

    private int findIndex(long[] nums, double target){
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid = (l + r)/2;
            if(nums[mid]>target){
                r = mid -1;
            }else{
                l = mid + 1;
            }
        }
        return l + 1;

    }
}
