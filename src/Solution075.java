public class Solution075 {
    public void sortColors(int[] nums) {
        int left=0,right=nums.length-1;
        for(int i=0;i<=right;i++){
            if(nums[i]==0){
                if(left<i){
                    swap(nums,left++,i--);
                }else{
                    left++;
                }
                continue;
            }
            if(nums[i]==2){
                swap(nums,right--,i--);
            }
        }
    }
    private void swap(int []nums,int i,int j){
        int temp= nums[i];
        nums[i] =nums[j];
        nums[j] =temp;
    }
}
