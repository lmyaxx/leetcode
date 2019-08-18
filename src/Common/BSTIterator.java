package Common;

import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack=new Stack<>();
    public BSTIterator(TreeNode root) {
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode root = stack.pop();
        int val = root.val;
        root=root.right;
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
