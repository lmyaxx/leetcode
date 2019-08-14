import Common.TreeNode;

public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,postorder,inorder.length-1,postorder.length-1,inorder.length);
    }
    // //       inorder = [9,3,15,20,7]
//        //postorder = [9,15,7,20,3]
    private TreeNode helper(int[] inorder, int[] postorder,int iright,int pright,int len){
        if(len>0){
            TreeNode root = new TreeNode(postorder[pright]);
            int rightLen=0;
            for(;rightLen<len;rightLen++){
                if(inorder[iright-rightLen]==postorder[pright]) break;
            }
            root.right = helper(inorder,postorder,iright,pright-1,rightLen);
            root.left = helper(inorder,postorder,iright-rightLen-1,pright-rightLen-1,len-1-rightLen);
            return root;
        }
        return null;
    }
}
