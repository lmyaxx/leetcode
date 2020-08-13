package solution601_800;

import Common.TreeNode;

/**
 * @Author : Chad li
 * @Date : 2020/2/28 15:43
 * @Version 1.0
 */
public class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 != null && t2 !=null){
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left,t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        } else {
            return t1 ==  null ? t2 : t1;
        }
        return t1;
    }
}
