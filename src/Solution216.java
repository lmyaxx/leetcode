import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : Chad li
 * @Date : 2020/3/12 8:58
 * @Version 1.0
 */
public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new LinkedList<>();
        if((9+9-k+1)*k/2<n){
            return res;
        }
        helper(k,n,1,res,cur);
        return res;
    }

    private void helper(int k,int n,int min,List<List<Integer>> res, List<Integer> cur){
        if(n==0&&k==0){
            res.add(new LinkedList<>(cur));
            return;
        }
        if(n==0||k==0){
            return;
        }
        for(int i = min;(i+i+k-1)*k/2<=n&&i<=9;i++){
            cur.add(i);
            helper(k-1,n-i,i+1,res,cur);
            cur.remove(cur.size()-1);
        }
    }
}
