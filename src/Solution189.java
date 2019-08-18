public class Solution189 {
    public void rotate(int[] nums, int k) {
        int rightLen = k% nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,rightLen-1);
        reverse(nums,rightLen,nums.length-1);
    }

    private void reverse(int []nums,int begin,int end){
        while(begin<end){
            int temp=nums[begin];
            nums[begin]=nums[end];
            nums[end]=temp;
            begin++;end--;
        }
    }
    //后移，出现循环则跳出
    public void rotate1(int []nums,int k){
        k%=nums.length;
        int index=k,loopHead=0,cur=nums[0];
        for(int i=0;i<nums.length;i++){
            if(loopHead==index){
                nums[loopHead]=cur;
                loopHead=(loopHead+1)%nums.length;
                cur=nums[loopHead];
                index++;
            }else{
                int temp=cur;
                cur=nums[index];
                nums[index]=temp;
            }
            index = (index+k)%nums.length;
        }
    }
}
