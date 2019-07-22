import java.util.List;

public class Solution061 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        ListNode left=head,right=head;
        int size=1;
        while(left.next!=null){
            size++;
            left=left.next;
        }
        left = head;
        k = k % size;
//      1->2->3->4->5->NULL
        while(k-->0){
            right=right.next;
        }
        while(right.next!=null){
            right=right.next;
            left=left.next;
        }
        right.next = head;
        head =left.next;
        left.next=null;
        return head;
    }
}
