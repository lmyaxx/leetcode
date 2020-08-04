package solution001_200;

import Common.TreeNode;

public class Solution156 {

    //wait for judge
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null||root.left==null) return root;
        return helper(root.left,root.right,root);
    }

    private TreeNode helper(TreeNode root,TreeNode left,TreeNode right){
        TreeNode nextRoot = root.left;
        TreeNode nextleft = root.right;
        right.right=null;
        root.left =left;
        root.right=right;
        if(nextRoot!=null)
            return helper(nextRoot,nextleft,root);
        else
            return root;
    }
}
