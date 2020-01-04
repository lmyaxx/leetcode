/**
 * @Author : Chad li
 * @Date : 2020/1/4 20:31
 * @Version 1.0
 */
public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        if(nums==null||nums.length<3){
            return false;
        }
        Integer first=nums[0],second=null;
        for(int i=1;i<nums.length;i++){
             if(nums[i]<=first){
                 first = nums[i];
             }else{
                 if(second == null){
                     second = nums[i];
                 }else{
                     if(nums[i]<=second){
                         second = nums[i];
                     }else{
                         return true;
                     }
                 }
             }
        }
        return false;
    }
}
