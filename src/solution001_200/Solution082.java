package solution001_200;

import Common.ListNode;

public class Solution082 {
    public ListNode deleteDuplicates(ListNode head) {
//        1->2->3->3->4->4->5
        ListNode result = new ListNode(-1);
        result.next=null;
        ListNode cur=result;
        int count=1;
        while(head!=null){
            if(head.next==null||head.next.val!=head.val){
                if(count==1){
                    cur.next=head;
                    cur = head;
                }
                count=1;
            }else{
                count++;
            }
            head=head.next;
            cur.next=null;
        }
        return result.next;
    }
}
