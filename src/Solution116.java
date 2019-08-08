public class Solution116 {
    public Node connect(Node root) {
        if(root==null) return root;
        if(root.left!=null){
            root.left.next = root.right;
            if(root.next!=null)
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public Node connect1(Node root){
        if(root==null) return null;
        Node start = root,cur;
        while(start.left!=null){
            cur = start;
            cur.left.next=cur.right;
            while(cur.next!=null){
                cur.right.next =cur.next.left;
                cur=cur.next;
                cur.left.next=cur.right;
            }
            start = start.left;
        }
        return  root;
    }
}
