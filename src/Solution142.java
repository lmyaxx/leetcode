import Common.ListNode;

import java.util.List;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode walker=head,runner = head;
        int count=0,meet=0;
        while(runner!=null&&runner.next!=null){
            walker=walker.next;
            runner=runner.next.next;
            count++;
            if(walker==runner){
                meet++;
                if(meet==1)
                    count=0;
                if(meet==2)
                    break;
            }
        }
        if(meet==0)
            return null;
        walker=head;
        runner=head;
        while(count-->0){
            runner=runner.next;
        }
        while(runner!=walker){
            runner=runner.next;
            walker=walker.next;
        }
        return runner;
    }
}
