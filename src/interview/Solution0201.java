package interview;
import Common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        Set<Integer> set = new HashSet<Integer>();
        set.add(head.val);
        ListNode iter = head;
        while(iter.next!=null){
            if(set.contains(iter.next.val)){
                iter.next = iter.next.next;
            }else{
                iter = iter.next;
                set.add(iter.val);
            }
        }
        return head;
    }
}
