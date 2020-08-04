package solution201_400;

import Common.ListNode;
import Common.TreeNode;

/**
 * @Author : Chad li
 * @Date : 2020/3/10 11:04
 * @Version 1.0
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null&&head.val == val){
            head = head.next;
        }
        if(head==null){
            return head;
        }
        ListNode last = head, cur = head.next;
        while(cur!=null){
            if(cur.val!=val){
                last = cur;
            }
            last.next = cur.next;
            cur = cur.next;
        }
        return head;
    }
}
