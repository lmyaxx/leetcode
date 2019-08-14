import Common.TreeNode;

public class Solution111 {
    int res = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        helper(root,1);
        return res;
    }
    private void helper(TreeNode root,int level){
        if(root==null||level>=res) return ;
        if(root.left==null&&root.right==null)
            res=Math.min(res,level);
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}
