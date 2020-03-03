import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root,new ArrayList<>(),res,sum,0);
        return res;
    }

    private void helper(TreeNode root,List<Integer> out,List<List<Integer>>res,int sum,int cul){
        if(root==null) {
            return;
        }
        out.add(root.val);
        cul+=root.val;
        if(root.left==null&&root.right==null&&cul==sum){
            res.add(new ArrayList<>(out));
            out.remove(out.size()-1);
            return;
        }
        helper(root.left,out,res,sum,cul);
        helper(root.right,out,res,sum,cul);
        out.remove(out.size()-1);
    }
}
