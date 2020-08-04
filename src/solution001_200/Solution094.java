package solution001_200;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    private void helper(TreeNode node, List<Integer> res){
        if(node==null) return;
        helper(node.left,res);
        res.add(node.val);
        helper(node.right,res);
    }
}
