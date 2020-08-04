package solution001_200;

import java.util.ArrayList;
import java.util.List;

public class Solution078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        for(int i=0,len =nums.length ;i<=len;i++){
            helper(result,i,0,len-1,out,nums);
        }
        return result;
    }

    private void helper(List<List<Integer>> result, int rest, int left,int right,List<Integer> out,int []nums){
        if(rest==0){
            result.add(new ArrayList<>(out));
            return ;
        }
        while(left<=right+1-rest){
            out.add(nums[left]);
            helper(result,rest-1,++left,right,out,nums);
            out.remove(out.size()-1);
        }
    }
}
