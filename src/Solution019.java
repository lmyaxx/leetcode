/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0)
            return head;
        ListNode rawHead = head,front=head;
        int len=0;
        while(head != null){
            if(len>n){
                front = front.next;
            }
            len++;
            head = head.next;
        }
        if(len==1)
            return null;
        if(len==n)
            return rawHead.next;
        front.next=front.next.next;
        return rawHead;
    }
}
