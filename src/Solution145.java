import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        traverse(root,res);
        return res;
    }
    private void traverse(TreeNode root,List<Integer> res){
        if(root==null) return;
        traverse(root.left,res);
        traverse(root.right,res);
        res.add(root.val);
    }

    private List<Integer> traverse1(TreeNode root){
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return res;
        stack.push(root);
        while(!stack.isEmpty()){
            root=stack.pop();
            ((LinkedList<Integer>) res).addFirst(root.val);
            if(root.left!=null){
                stack.push(root.left);
            }
            if(root.right!=null){
                stack.push(root.right);
            }
        }
        return res;
    }
}
