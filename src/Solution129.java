public class Solution129 {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }

    private int helper(TreeNode root,int num){
       if(root==null)
           return 0;
       num = num*10+root.val;
       if(root.left==null&&root.right==null)
           return num;
       return helper(root.left,num)+helper(root.right,num);
    }
}
