package solution001_200;

import Common.ListNode;
import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        traverse(root,res);
        return res;
    }

    private void traverse(TreeNode root, List<Integer>res){
        if(root==null) return;
        res.add(root.val);
        traverse(root.left,res);
        traverse(root.right,res);
    }

    private List<Integer> traverse1(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            while(cur!=null){
                res.add(cur.val);
                if(cur.right!=null){
                    stack.push(cur.right);
                }
                cur = cur.left;
            }
        }
        return res;
    }
}
