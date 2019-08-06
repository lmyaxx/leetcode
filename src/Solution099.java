public class Solution099 {
    public void recoverTree(TreeNode root) {
        TreeNode pre = new TreeNode(0);
        pre.left=null;
        pre.right=null;
        helper(root,pre);
        pre.val = pre.left.val;
        pre.left.val = pre.right.val;
        pre.right.val = pre.val;
    }
    //    boolean means if we need continue to find the answer
    private boolean helper(TreeNode cur,TreeNode pre){
        if(cur==null) return true;
        if(!helper(cur.left,pre)) return false;
        if(pre.val==0){
            if(pre.left==null){
                pre.left=cur;
            }else{
                if(pre.left.val>cur.val){
                    pre.val=1;
                    pre.right=cur;
                }else{
                    pre.left =cur;
                }
            }

        }else {
            if(cur.val<pre.left.val){
                pre.right =cur;
            }else{
                return false;
            }
        }
        return helper(cur.right,pre);
    }
}
