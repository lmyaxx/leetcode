package solution001_200;

import Common.ListNode;

public class Solution021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                cur = cur.next = l2;
                l2 = l2.next;
            }else{
                cur = cur.next = l1;
                l1 = l1.next;
            }
        }
        if(l1==null) cur.next=l2;
        if(l2==null) cur.next=l1;
        return pre.next;
    }
    //递归出奇迹
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next = mergeTwoLists1(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists1(l1,l2.next);
            return l2;
        }
    }
}
