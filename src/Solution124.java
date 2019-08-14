import Common.TreeNode;

public class Solution124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    private int helper(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = Math.max(0,helper(root.left));
        int right = Math.max(0, helper(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left + root.val, right + root.val);
    }
}
