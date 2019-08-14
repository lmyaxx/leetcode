import Common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        // cur is the first element of the next circle
        for(int i=0;i<k;i++){
            if(cur==null)
                return head;
            cur = cur.next;
        }
        ListNode pre=head,now=pre.next,temp=null;
        for(int i=1;i<k;i++){
            temp=now.next;
            now.next=pre;
            pre=now;
            now=temp;
        }
        head.next = reverseKGroup(cur,k);
        return pre;
    }
}