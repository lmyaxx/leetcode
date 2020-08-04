package solution001_200;

import Common.ListNode;

import java.util.List;

public class Solution148 {
    //mergeSort  not recurcive
    public ListNode sortList(ListNode head) {
        ListNode res = new ListNode(-1);
        res.next=head;
        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }
        for(int width=1;width<=len;width*=2){
            int len1,len2;
            ListNode mid=res,cur1,cur2,next;
            while(mid.next!=null){
                cur1=cur2=mid.next;
                for(len1=0;len1<width&&cur2!=null;len1++){
                    cur2=cur2.next;
                }
                next=cur2;
                for(len2=0;len2<width&&next!=null;len2++){
                    next=next.next;
                }
                while(len1>0&&len2>0){
                    if(cur1.val>=cur2.val){
                        mid.next=cur2;
                        cur2=cur2.next;
                        len2--;
                    }else{
                        mid.next=cur1;
                        cur1=cur1.next;
                        len1--;
                    }
                    mid=mid.next;
                }
                while(len1-->0){
                    mid.next=cur1;
                    cur1=cur1.next;
                    mid=mid.next;
                }
                while(len2-->0){
                    mid.next=cur2;
                    cur2=cur2.next;
                    mid=mid.next;
                }
                mid.next=next;
            }
        }
        return res.next;
    }
}
