package solution201_400;

import Common.ListNode;

/**
 * @Author : Chad li
 * @Date : 2020/1/4 18:39
 * @Version 1.0
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        odd.next = null;
        even.next = null;
        ListNode ocur = odd;
        ListNode ecur = even;
        boolean isOdd = true;
        while(head!=null){
            if(isOdd){
                ocur.next = head;
                ocur = ocur.next;
            }else{
                ecur.next = head;
                ecur = ecur.next;
            }
            head = head.next;
            isOdd = !isOdd;
        }
        ocur.next = even.next;
        ecur.next = null;
        return odd.next;
    }
}
