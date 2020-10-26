import java.util.TreeMap;

public class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] ans = new int[nums.length];
        for(int num: nums){
            count[num]++;
        }
        for(int i = 1; i< count.length ; i++){
            count[i] += count[i-1];

        }
        for(int i = 0; i<ans.length;i++){
            if(nums[i]==0){
                ans[i] = 0;
            }else{
                ans[i] = count[nums[i]-1];
            }
        }
        return ans;
    }
}
