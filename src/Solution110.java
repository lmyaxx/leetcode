import Common.TreeNode;

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return helper(root)!=-1;
    }
    private int helper(TreeNode root){
        if(root==null) return 0;
        int left = helper(root.left);
        if(left<0) return -1;
        int right = helper(root.right);
        if(right<0) return -1;
        if(Math.abs(left-right)<=1){
            return Math.max(left,right)+1;
        }
        return -1;
    }
}
