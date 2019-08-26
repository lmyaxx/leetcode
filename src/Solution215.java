public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int low = 0,high = nums.length-1,kth=nums.length-k;
        while (true){
            int pos = partition(nums,low,high);
            if(pos==kth){
                return nums[pos];
            }else if(pos<kth){
                low = pos+1;
            }else{
                high=pos-1;
            }
        }
    }

    private int partition(int []nums,int low,int high){
        int cur = low - 1;
        while(low<=high){
            if(nums[low]>nums[high]){
                low++;
            }else{
                swap(nums,++cur,low++);
            }
        }
        return cur;
    }
    private void swap(int []nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
