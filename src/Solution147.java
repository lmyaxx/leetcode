import Common.ListNode;

import java.util.List;

public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode cur,next=head;
        ListNode res = new ListNode(Integer.MIN_VALUE);
        res.next=null;
        while(next!=null){
            cur=next;
            next=next.next;
            ListNode one = res,two=res.next;
            while(two!=null&&cur.val>=two.val){
                one=two;
                two=two.next;
            }
            one.next=cur;
            cur.next=two;
        }
        return res.next;
    }
}
