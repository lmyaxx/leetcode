import Common.ListNode;

public class Solution086 {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return head;
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode left=head,right=left.next;
        if(head.val>=x) head=result;
        while(right!=null){
            if(right.val<x){
                if(left.val>=x){
                    left.next = right.next;
                    right.next=head.next;
                    head.next = right;
                }else{
                    left = right;
                }
                head=head.next;
            }else{
                left=left.next;
            }
            right=left.next;
        }
        return result.next;
    }

    public ListNode partition1(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode curSmall = small;
        ListNode curLarge = large;
        while (head != null) {
            if (head.val < x) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        curSmall.next = large.next;
        curLarge.next = null;
        return small.next;
    }
}
