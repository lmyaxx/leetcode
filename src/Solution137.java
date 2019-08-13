public class Solution137 {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int i=1;i<=32;i++){
            int count=0;
            for(int j=0,len=nums.length;j<len;j++){
                if(((nums[j]>>i)&1)==1){
                    count++;
                    if(count==3)
                        count=0;
                }
            }
            if(count!=0){
                res|=1<<i;
            }
        }
        return res;
    }
}
