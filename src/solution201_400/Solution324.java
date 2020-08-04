package solution201_400;

import java.util.Random;

/**
 * @Author : Chad li
 * @Date : 2019/10/31 10:24
 * @Version 1.0
 */
public class Solution324 {
    public void wiggleSort(int[] nums) {
        int mid = (nums.length + 1) / 2 ;
        int middle = findKthLargest(nums,mid);
        int n = nums.length;
        int left = 0, right = nums.length - 1, i = 0;
        while(i<=right){
            if(nums[newIndex(i,n)]>middle){
                swap(nums,newIndex(i++,n),newIndex(left++,n));
            }else if(nums[newIndex(i,n)]<middle){
                swap(nums,newIndex(right--,n),nums[newIndex(i,n)]);
            } else {
                i++;
            }
        }
    }

    public int newIndex(int i, int n){
        return (2*i + 1)*(n|1);
    }


    private int findKthLargest(int []nums, int k){
        shuffle(nums);
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int pos = partition(nums, low, high);
            if( pos < k - 1 ){
                low = pos+1;
            }else if(pos> k-1){
                high= pos -1;
            }else{
                break;
            }
        }
        return nums[k-1];
    }

    public int partition(int []nums,int low, int high){
        int pivot = nums[high];
        for(int i = low; i<high;i++){
            if(nums[i]>=pivot){
                swap(nums,low++,i);
            }
        }
        swap(nums,low,high);
        return low;
    }

    public void swap(int []nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private void shuffle(int nums[]) {
        final Random random = new Random();
        for(int i = 1; i < nums.length; i++) {
            final int r = random.nextInt(i + 1);
            swap(nums, i, r);
        }
    }
}
