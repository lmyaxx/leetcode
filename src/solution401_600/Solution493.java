package solution401_600;

/**
 * @Author : Chad li
 * @Date : 2020/4/18 11:53
 * @Version 1.0
 */
public class Solution493 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    private int mergeSort(int[] nums,int left, int right){
        if(left>=right){
            return 0;
        }
        int mid = (left+right) / 2;
        int res  = 0;
        res += mergeSort(nums,left,mid);
        res += mergeSort(nums,mid+1,right);
        int cur = mid + 1;
        for(int i=left;i<=mid;i++){
            while(cur<=right&&nums[i]/2.0>nums[cur]){
                cur++;
            }
            res += cur - mid - 1;
        }
        merge(nums,left,right);
        return res;
    }

    private void merge(int[] nums,int left, int right){
        int[] cache = new int[right-left+1];
        int mid = (left+right)/2;
        int i = left, j = mid + 1;
        int count = 0;
        while(i<=mid&&j<=right){
            if(nums[i]>=nums[j]){
                cache[count++] = nums[j++];
            }else{
                cache[count++]= nums[i++];
            }
        }
        while(i<=mid){
            cache[count++] = nums[i++];
        }
        while(j<=right){
            cache[count++] = nums[j++];
        }
        while(count>=1){
            nums[right--] = cache[--count];
        }
    }
}
