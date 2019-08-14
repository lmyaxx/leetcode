import Common.Node;

public class Solution117 {
    public Node connect(Node root) {
        if(root==null) return root;
        if(root.left==null&&root.right==null) return root;
        Node cur = root.next;
        while(cur!=null){
            if(cur.left!=null){
                cur=cur.left;
                break;
            }
            if(cur.right!=null){
                cur=cur.right;
                break;
            }
            cur=cur.next;
        }
        if(root.left==null) root.right.next=cur;
        else if(root.right==null) root.left.next=cur;
        else{
            root.left.next =root.right;
            root.right.next=cur;
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
}
