package solution001_200;

import Common.ListNode;

public class Solution083 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode left=head,right=head.next;
        while(right!=null){
            if(right.val!=left.val){
                left.next = right;
                left=right;
            }
            right=right.next;
        }
        left.next = right;
        return head;
    }
}
