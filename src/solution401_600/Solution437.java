package solution401_600;

import Common.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : Chad li
 * @Date : 2020/2/26 11:39
 * @Version 1.0
 */
public class Solution437 {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        return findPathSum(root,0,sum, map);
    }

    private int findPathSum(TreeNode root, int sum, int target, Map<Integer,Integer> map){
        if(root==null){
            return 0;
        }
        sum += root.val;
        int numPathToCur = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        int res = numPathToCur + findPathSum(root.left, sum, target, map) + findPathSum(root.right, sum, target, map);
        map.put(sum,map.get(sum) -1);
        return res;
    }
}
