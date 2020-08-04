package solution201_400;

import Common.ListNode;
import Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pp = new ArrayList<>();
        List<TreeNode> qq = new ArrayList<>();
        findAncestor(root,p,pp);
        findAncestor(root,q,qq);
        int len = Math.min(pp.size(),qq.size());
        TreeNode result=null;
        for(int i=0;i<len;i++){
            if(pp.get(i)==qq.get(i))
                result = pp.get(i);
            else
                return result;
        }
        return result;
    }

    private boolean findAncestor(TreeNode root,TreeNode target,List<TreeNode> path){
        path.add(root);
        if(root==target){
            return true;
        }
        if(root.left!=null&&findAncestor(root.left,target,path))
            return true;
        if(root.right!=null&&findAncestor(root.right,target,path))
            return true;
        path.remove(path.size()-1);
        return false;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==root||q==root) return root;
        TreeNode left = lowestCommonAncestor1(root.left,p,q);
        TreeNode right = lowestCommonAncestor1(root.right,p,q);
        if(left!=null&&right!=null)
            return root;
        if(left==null)
            return right;
        return left;
    }
}
