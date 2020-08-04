package solution001_200;

import Common.ListNode;

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode walker = head,runner = head;
        while(runner!=null&&runner.next!=null){
            walker=walker.next;
            runner=runner.next.next;
            if(runner==walker)
                return true;
        }
        return false;
    }
}
