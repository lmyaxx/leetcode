package solution001_200;

import java.util.*;

public class Solution040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        int right = candidates.length - 1;
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
                helper(candidates,i-1,target-candidates[i],stack,result);
                stack.remove(stack.size()-1);
            }
            if(i>=1&&candidates[i-1]==candidates[i])
                i--;
        }
    }
}
