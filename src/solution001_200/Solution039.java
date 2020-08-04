package solution001_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int right = candidates.length-1;
        List<Integer> stack = new ArrayList<>();
        helper(candidates,right,target,stack,result);
        return result;
    }

    private void helper(int[] candidates,int right,int target,List<Integer> stack,List<List<Integer>> result){
        for(int i=right;i>=0;i--){
            if(candidates[i]-target==0) {
                stack.add(candidates[i]);
                result.add(new ArrayList<>(stack));
                stack.remove(stack.size()-1);
            }
            if(candidates[i]< target){
                stack.add(candidates[i]);
                helper(candidates,i,target-candidates[i],stack,result);
                stack.remove(stack.size()-1);
            }
        }
    }
}
