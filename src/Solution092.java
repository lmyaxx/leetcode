import Common.ListNode;

import java.awt.*;

public class Solution092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m>n) return reverseBetween(head,n,m);
        ListNode result = new ListNode(-1);
        result.next = head;
//        between 1 and 4
//begin       pre,left  right  head
//                       [1,    2,    3,    4]
// end            pre               left  right head
//                      [1,    2,    3,    4]
        ListNode pre=result,left,right;
        int i=1;
        for(;i<m;i++){
            pre = pre.next;
        }
        left=pre;right=left.next;head=right.next;
        for(;i<n;i++){
            left=right;
            right=head;
            head=head.next;
            right.next=left;
        }
        pre.next.next = head;
        pre.next=right;
        return result.next;
    }
}
