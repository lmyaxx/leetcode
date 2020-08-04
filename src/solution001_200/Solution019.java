package solution001_200;

import Common.ListNode;

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
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(n==0)
            return head;
        ListNode pre = head,next=head;
        for(int i=0;i<n;i++){
            next=next.next;
        }
        if(next == null) return pre.next;
        while(next.next!=null){
            next = next.next;
            pre = pre.next;
        }
        pre.next=pre.next.next;
        return head;
    }
}
