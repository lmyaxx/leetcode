package solution001_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution090 {
//    [1,2,2]
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    List<Integer> out = new ArrayList<>();
    for(int i=0;i<=nums.length;i++){
        helper(nums,0,i,out,result);
    }
    return result;
}
    private void helper(int[] nums,int start,int rest,List<Integer> out,List<List<Integer>> result){
        if(rest==0) {
            result.add(new ArrayList(out));
            return;
        }
        for(int i=start;i<=nums.length-rest;i++){
            if(i>start&&nums[i]==nums[i-1])
                continue;
            out.add(nums[i]);
            helper(nums,i+1,rest-1,out,result);
            out.remove(out.size()-1);
        }
    }
}
