import Common.TreeNode;

/**
 * @Author : Chad li
 * @Date : 2020/2/5 17:15
 * @Version 1.0
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
}
