public class Solution021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head,cur,cur1=l1,cur2=l2;
        if(l1.val>l2.val){
            cur=head=l2;
            cur2=cur2.next;
        }else{
            cur=head = l1;
            cur1=cur1.next;
        }
        while(l1!=null&&l2!=null){
            if(cur1.val>cur2.val){
                cur = cur.next = cur2;
                cur2 = cur2.next;
            }else{
                cur= cur.next = cur1;
                cur1 = cur1.next;
            }
        }
        cur.next = l1==null? cur2:cur1;
        return head;
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
