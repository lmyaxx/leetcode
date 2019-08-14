import Common.TreeNode;

public class Solution112 {
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        helper(root,sum,0);
        return res;
    }

    private void helper(TreeNode root,int sum,int total){
        if(res||root==null) return;
        total+=root.val;
        if(root.left==null&&root.right==null) res = sum==total;
        helper(root.left,sum,total);
        helper(root.right,sum,total);
    }
}
