import Common.ListNode;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        int len=0;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        if(len<2) {
            return true;
        }
        int half = (len+1)/2;
        ListNode halfHead = head;
        for(int i= 0;i<half;i++){
            halfHead = halfHead.next;
        }
        //reverse
        ListNode newHead = reverse(halfHead);
        halfHead = newHead;
        while(newHead!=null){
            if(newHead.val!=head.val)
                return false;
            newHead = newHead.next;
            head = head.next;
        }
        //restore
        reverse(halfHead);
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode cur = head.next;
        head.next=null;
        ListNode one ;
        while(cur!=null){
            one = cur.next;
            cur.next = head;
            head = cur;
            cur =one;
        }
        return head;
    }
}
