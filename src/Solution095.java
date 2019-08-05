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
}
