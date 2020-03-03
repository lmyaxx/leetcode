import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution015 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        for(int i=0;i<len-2&&nums[i]<=0;i++){
            if(i>0&&nums[i]==nums[i-1]) {
                continue;
            }
            int left=i+1,right=len-1;
            while(left<right){
                if(nums[left]+nums[right]==-nums[i]){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right&&nums[left+1]==nums[left]) {
                        left++;
                    }
                    while(left<right&&nums[right-1]==nums[right]) {
                        right--;
                    }
                    left++;right--;
                }else if(nums[left]+nums[right]<-nums[i]){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
}
