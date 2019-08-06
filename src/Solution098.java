import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Solution098 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> compare=new ArrayList<>();
        return helper(root,compare);
    }
    private boolean helper(TreeNode root,List<Integer> compare){
        if(root==null) return true;
        if(helper(root.left,compare)){
            if(compare.isEmpty()){
                compare.add(root.val);
            }else {
                if(root.val<=compare.get(0))
                    return false;
                compare.set(0,root.val);
            }
            return helper(root.right,compare);
        }
        return false;
    }

    public boolean isValidBST1(TreeNode root) {
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        return helper1(root, max, min);
    }
    private boolean helper1(TreeNode root, long max, long min) {
        if(root == null) {
            return true;
        }
        if(root.val <= min || root.val >= max) {
            return false;
        }
        return helper1(root.left, root.val, min) && helper1(root.right, max, root.val);
    }

}
