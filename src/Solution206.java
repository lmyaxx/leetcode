import Common.ListNode;

public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null,post;
        while(head!=null){
            post=head.next;
            head.next=pre;
            pre=head;
            head=post;
        }
        return pre;
    }
}
