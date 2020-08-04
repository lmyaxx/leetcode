package solution001_200;

import Common.ListNode;
import Common.TreeNode;

public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode pre = head;
        int len=0;
        while(pre!=null){
            pre=pre.next;
            len++;
        }
        return helper(head,len);
    }
    private TreeNode helper(ListNode head,int len){
        if(len<1) return null;
        int mid = len/2+1;
        ListNode cur = head;
        for(int i=1;i<mid;i++){
            cur=cur.next;
        }
        TreeNode root = new TreeNode(cur.val);
        root.left = helper(head,len/2);
        root.right = helper(cur.next,len-1-len/2);
        return root;
    }
}
