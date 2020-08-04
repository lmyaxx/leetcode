package solution201_400;

import Common.TreeNode;

/**
 * @Author : Chad li
 * @Date : 2020/3/15 10:04
 * @Version 1.0
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null){
            return root;
        }else{
            if(left!=null){
                return left;
            }
            if(right!=null){
                return right;
            }
            return null;
        }
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = p.val < root.val ? root.left : root.right;
        }
        return root;
    }
}
