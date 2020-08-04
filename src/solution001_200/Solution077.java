package solution001_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result,k,1,n,new ArrayList<>());
        return result;
    }
    public void helper(List<List<Integer>> result,int rest,int left,int right,List<Integer> out){
        if(rest==0) {
            result.add(new ArrayList<>(out));
            return ;
        }
        while(left<=right+1-rest){
            out.add(left);
            helper(result,rest-1,++left,right,out);
            out.remove(out.size()-1);
        }
    }
}
