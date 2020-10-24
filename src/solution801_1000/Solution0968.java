package solution801_1000;

import Common.TreeNode;

public class Solution0968 {
    public int minCameraCover(TreeNode root) {
        int[] res = helper(root);
        return res[1];
    }

    //list[0] 我罩你， list[1] 自保， list[2] 求罩
    private int[] helper(TreeNode root){
        if(root == null){
            return new int[]{1000, 0, 0};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int a = 0, b = 0, c = 0;
        a = min(left) + min(right) + 1;
        b = Math.min(left[0]+Math.min(right[0],right[1]), right[0] +Math.min(left[0],left[1]));
        b = Math.min(a, b);
        c = Math.min(left[1]+right[1],b);
        return new int[]{a,b,c};
    }
    private int min(int[] nums){
        int res = 10000;
        for(int num: nums){
            res = Math.min(res, num);
        }
        return res;
    }
}
