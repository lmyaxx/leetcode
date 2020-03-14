import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Chad li
 * @Date : 2020/3/13 16:04
 * @Version 1.0
 */
public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int end = helper(nums,i);
            if(i==end){
                res.add(Integer.toString(nums[i]));
            }else{
                res.add(nums[i] + "->" + nums[end]);
                i=end;
            }
        }
        return res;
    }

    private int helper(int[] nums, int start){
        int low = 0,high = 1;
        while (start+high<nums.length&&nums[start+high]-nums[start]==high){
            low = high;
            high*=2;
        }
        if(start+high>=nums.length){
            high = nums.length-1-start;
        }
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[start+mid]-nums[start] == mid){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return start + low - 1;
    }
}
