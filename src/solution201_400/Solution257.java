package solution201_400;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Chad li
 * @Date : 2020/3/15 20:15
 * @Version 1.0
 */
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        if(root.left!=null){
            List<String> left = binaryTreePaths(root.left);
            for(String s:left){
                res.add(root.val+"->"+s);
            }
        }
        if(root.right!=null){
            List<String> right = binaryTreePaths(root.right);
            for(String s:right){
                res.add(root.val+"->"+s);
            }
        }
        if(root.left==null&&root.right==null){
            res.add(String.valueOf(root.val));
        }
        return res;
    }
    public List<String> binaryTreePaths1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        traverse(root,sb,res);
        return res;
    }

    private void traverse(TreeNode root, StringBuilder sb,List<String> res){
        if(root==null){
            return;
        }
        int len = sb.length();
        if(root.left==null&&root.right==null){
            res.add(sb.toString()+root.val);
        } else{
            sb.append(root.val+"->");
            if(root.left!=null){
                traverse(root.left,sb,res);
            }
            if(root.right!=null){
                traverse(root.right,sb,res);
            }
            sb.setLength(len);
        }
    }
}
