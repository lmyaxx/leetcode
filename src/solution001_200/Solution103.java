package solution001_200;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        helper(root,result,0);
        return result;
    }

    private void helper(TreeNode root,List<List<Integer>> res,int level){
        if(root==null) return;
        if(level==res.size()){
            res.add(new LinkedList<>());
        }
        if(level%2==0){
            res.get(level).add(0,root.val);
        }else{
            res.get(level).add(res.get(level).size(),root.val);
        }
        helper(root.left,res,level+1);
        helper(root.right,res,level+1);
    }
}
