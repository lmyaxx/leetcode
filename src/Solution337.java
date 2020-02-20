import Common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Chad li
 * @Date : 2020/2/20 15:15
 * @Version 1.0
 */
public class Solution337 {
    public int rob1(TreeNode root) {
        HashMap<TreeNode,Integer> map = new HashMap<>();
        map.put(null,0);
        return helper(root,map);
    }

    public int helper(TreeNode root, Map<TreeNode,Integer> map) {
        if(map.containsKey(root)) {
            return map.get(root);
        }
        int max = root.val;
        if(root.left != null){
            max += helper(root.left.left,map) + helper(root.left.right,map);
        }
        if(root.right != null){
            max += helper(root.right.left, map) + helper(root.right.right,map);
        }
        max = Math.max(max,helper(root.left, map) + helper(root.right,map));
        map.put(root,max);
        return max;
    }

    public int rob2(TreeNode root){
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }

    public int[] helper(TreeNode root){
        if(root==null) {
            return new int[]{0,0};
        }
        int []left,right;
        left = helper(root.left);
        right = helper(root.right);
        int[] res = new int[2];
        res[0] =  Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}
