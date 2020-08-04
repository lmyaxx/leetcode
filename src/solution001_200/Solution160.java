package solution001_200;

import Common.ListNode;

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur=headA;
        int a=0,b=0;
        while(cur!=null){
            a++;
            cur=cur.next;
        }
        cur=headB;
        while(cur!=null){
            b++;
            cur=cur.next;
        }
        while(a>b){
            headA=headA.next;
            a--;
        }
        while(b>a){
            headB=headB.next;
            b--;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
