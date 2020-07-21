import Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution095 {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new LinkedList<>();
        return generateSubtrees(1, n);
    }

    private List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (s > e) {
            res.add(null); // empty tree
            return res;
        }
        for(int i=s;i<=e;i++){
            List<TreeNode> leftSubTree = generateSubtrees(s,i-1),rightSubTree=generateSubtrees(i+1,e);
            for(TreeNode left:leftSubTree){
                for(TreeNode right:rightSubTree){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
    public List<TreeNode> generateTrees1(int n) {
        if(n<1){
            return new ArrayList<TreeNode>();
        }
        return helper(1,n);
    }

    private List<TreeNode> helper(int start, int end){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(start>end){
            res.add(null);
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left = helper(start,i-1);
            List<TreeNode> right = helper(i+1,end);
            int finalI = i;
            left.forEach((TreeNode former)->{
                right.forEach((TreeNode latter)->{
                    res.add(new TreeNode(finalI,deepCopy(former),deepCopy(latter)));
                });
            });
        }
        return res;
    }

    private TreeNode deepCopy(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode nRoot = new TreeNode(root.val);
        nRoot.left = deepCopy(root.left);
        nRoot.right = deepCopy(root.right);
        return nRoot;
    }
}
