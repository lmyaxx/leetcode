public class Solution300 {

    // o(n^2) time complex
    public int lengthOfLIS(int[] nums) {
        int size[] = new int[nums.length];
        int result = 0;
        for(int i=0;i<nums.length;i++){
            size[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    size[i] = Math.max(size[i],size[j]+1);
                }
            }
            result = Math.max(result,size[i]);
        }
        return result;
    }
    // O(nlog(n)复杂度)
    public int lengthOfLIS1(int[] nums) {
        int size[] = new int[nums.length];
        int result=0;
        for(int num:nums){
            int i=0,j=result;
            while (i!=j){
                int mid = (i+j)/2;
                if(num>size[mid]){
                    i=mid+1;
                }else {
                    j=mid;
                }
            }
            size[j]=num;
            if(j==result) {
                result++;
            }
        }
        return result;
    }
}
