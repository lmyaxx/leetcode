public class Solution124 {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return result;
    }
    private int helper(TreeNode root){
        int left=0,right=0;
        if(root.left!=null)
            left = helper(root.left);
        if(root.right!=null)
            right = helper(root.right);
        int temp=root.val;
        int withoutParent = root.val;
        if(left>0) withoutParent+=left;
        if(right>0) withoutParent+=right;
        result = Math.max(withoutParent,result);
        int max= Math.max(left,right);
        if(root.val+max>0){
            if(max<0)
                return root.val;
            else return root.val+max;
        }
        return 0;
    }
}
