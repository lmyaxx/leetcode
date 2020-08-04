package solution401_600;

import Common.TreeNode;

/**
 * @Author : Chad li
 * @Date : 2020/2/27 15:02
 * @Version 1.0
 */
public class Solution543 {
    //
    public int diameterOfBinaryTree(TreeNode root) {
        if(root ==null) {
            return 0;
        }
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }

    /**
     *  return:
     *  index = 0 means the value can be used
     *  index = 1 means the value can not be used
     */
    private int[] helper(TreeNode root){
        if(root== null){
            return new int[]{0,0};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0],right[0]) + 1;
        res[1] = Math.max(Math.max(left[0] + right[0] + 1, right[1]),left[1]);
        return res;
    }
}
