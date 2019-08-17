public class Solution152 {
    public int maxProduct(int[] nums) {
        int res=Integer.MIN_VALUE,adjacent=1,negative=1,left=0,right=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                res = Math.max(res,0);
                negative=1;
                adjacent=1;
                left=0;
                right=0;
                continue;
            }
            if(negative>0){
                negative*=nums[i];
                left++;
            }
            right++;
            adjacent*=nums[i];
            if(adjacent<0&&negative<0&&left!=right){
                res = Math.max(adjacent/negative,res);
            }else{
                res = Math.max(adjacent,res);
            }
        }
        return res;
    }
}
