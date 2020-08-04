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
public class Solution024 {
    public ListNode swapPairs(ListNode head) {
        if(head!=null&&head.next!=null){
            ListNode rear = head.next;
            head.next=swapPairs(rear.next);
            rear.next =head;
            return rear;
        }
        return head;
    }
}