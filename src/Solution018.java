import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int i,j,left,right,temp;
        List<List<Integer>> result = new ArrayList<>();
        for(i=0;i<len-3&&nums[i]+nums[i+1]+nums[i+2]+nums[i+3]<=target;i++){
            if(i>0&&nums[i-1]==nums[i])
                continue;
            for(j=i+1;j<len-2&&nums[i]+nums[j]+nums[j+1]+nums[j+2]<=target;j++){
                if(j>i+1&&nums[j-1]==nums[j])
                    continue;
                left=j+1; right=len-1;
                while(left<right&&nums[i]+nums[j]+nums[left]+nums[left+1]<=target){
                    temp = nums[i]+nums[j]+nums[left]+nums[right];
                    if(temp == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right&&nums[left]==nums[left+1]) left++;
                        while(left<right&&nums[right]==nums[right-1]) right--;
                        left++;right--;
                    }else if(temp<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
