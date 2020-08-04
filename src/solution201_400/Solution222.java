package solution201_400;

import Common.TreeNode;

/**
 * @Author : Chad li
 * @Date : 2020/3/13 9:05
 * @Version 1.0
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }

    private int getHeight(TreeNode root){
        int height = 0;
        while(root!=null){
            height++;
            root = root.left;
        }
        return height;
    }

    public int countNodes1(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(left==right){
            return (1<<left )+ countNodes1(root.right);
        }else{
            // 1 + ((1<<right) -1)
            return (1<<right) + countNodes1(root.left);
        }
    }
}
