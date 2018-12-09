class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        int extral=0;
        int sum=0;
        while(l1!=null || l2!=null || extral!=0){
            sum = (l1 != null ? l1.val: 0) + (l2!=null ? l2.val : 0) + extral;
            ListNode one = new ListNode(sum%10);
            extral = sum / 10;
            pre.next = one;
            pre = one;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        pre.next = null;
        return head.next ;
    }
}
