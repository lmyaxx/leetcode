import java.util.Arrays;

public class Solution105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
//  [2,1,4,3,5]
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7]
//   [9]  [3]    [15,20,7]
//  [9]   [3]     [20,15,7]
    private TreeNode helper(int []preorder,int pleft,int pright,int [] inorder,int ileft,int iright){
        if(pleft<=pright){
            TreeNode root = new TreeNode(preorder[pleft]);
            int leftnum = 0;
            for(int i=ileft;i<=iright;i++){
                if(inorder[i]==preorder[pleft]){
                    break;
                }
                leftnum++;
            }
            root.left = helper(preorder,pleft+1,pleft+leftnum,inorder,ileft,ileft+leftnum-1);
            root.right= helper(preorder,pleft+leftnum+1,pright,inorder,ileft+leftnum+1,iright);
            return root;
        }
        return null;
    }
}
