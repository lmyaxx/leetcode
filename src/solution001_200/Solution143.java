package solution001_200;

import Common.ListNode;

import java.util.List;

public class Solution143 {
    public void reorderList(ListNode head) {
        if(head==null) return;
        int len=0;
        ListNode front=head,end=head,cur;
        //get length
        while(end!=null){
            len++;
            end=end.next;
        }
        cur=head;
        int left = (len-1)/2;
        while(left-->0){
           cur=cur.next;
        }
        //reverse
        end=reverse(cur.next);
        cur.next=null;
        //merge
        while(end!=null){
            cur=front.next;
            front.next=end;
            end=end.next;
            front.next.next=cur;
            front=cur;
        }
    }

    private ListNode reverse(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode pre=head,cur=head.next,next=cur.next;
        pre.next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
