import Common.TreeNode;

public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
       int memo[] = {0,0};
       helper(root,memo,k);
       return memo[1];
    }

    private void helper(TreeNode root,int []memo,int k){
        if(root.left!=null){
            helper(root.left,memo,k);
        }
        if(memo[0]==k){
            return;
        }else{
            memo[0]++;
        }
        if(memo[0]==k){
            memo[1]=root.val;
            return;
        }
        if(root.right!=null){
            helper(root.right,memo,k);
        }
    }
}
