package solution001_200;

public class Solution045 {
    public int jump(int[] nums) {
        int len = nums.length;
        if( len==1) return 0;
        int left=0,right=0;
        int result=0;
        while(right<=len){
            int temp = right;
            result ++;
            while(left<=temp){
                right = Math.max(left + nums[left],right);
                if(right>=len-1)
                    return result;
                left++;
            }
        }
        return result;
    }
}
