package solution001_200;

import Common.TreeNode;

import java.awt.*;

public class Solution114 {
    public void flatten(TreeNode root) {
        helper(root);
    }
    private TreeNode helper(TreeNode root){
        if(root==null) return null;
        while(root.right!=null){
            if(root.left==null){
                root=root.right;
            }else{
                TreeNode next = root.right;
                root.right = root.left;
                root.left =null;
                helper(root.right).right = next;
                root=next;
            }
        }
        if(root.left==null){
            return root;
        }else{
            root.right = root.left;
            root.left = null;
            return  helper(root.right);
        }
    }

    public void flatten1(TreeNode root) {
        if(root==null)
            return;
        flatten1(root.left);
        flatten1(root.right);
        TreeNode left  = root.left;
        TreeNode right = root.right;
        root.left  = null;
        root.right = left;
        while(root.right!=null)
            root = root.right;
        root.right = right;
    }

    public void flatten2(TreeNode root){
        helper1(root,null);
    }

    private TreeNode  helper1(TreeNode root,TreeNode pre){
        if(root==null) return pre;
        pre = helper1(root.right,pre);
        pre = helper1(root.left,pre);
        root.right = pre;
        root.left = null;
        return root;
    }
}
