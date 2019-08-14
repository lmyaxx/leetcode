import Special.Leetcode138.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution138 {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        return clone(head,map);
    }
    public Node clone(Node head,Map<Node,Node> map){
        if(head==null) return null;
        if(map.containsKey(head)) return map.get(head);
        Node cur = new Node();
        map.put(head,cur);
        cur.val = head.val;
        cur.next = clone(head.next,map);
        cur.random = clone(head.random,map);
        return  cur;
    }
    public Node copyRandomList1(Node head){
        if(head==null) return head;
        Node iter = head,cur=null;
//        
        while(iter!=null){
            iter.next = new Node(iter.val,iter.next,null);
            iter = iter.next.next;
        }
        iter=head;
        while(iter!=null){
            if(iter.random!=null){
                iter.next.random = iter.random.next;
            }
            iter=iter.next.next;
        }
        iter=head;
        cur=iter.next;
        while(iter.next!=null){
            head = iter.next;
            iter.next =iter.next.next;
            iter=head;
        }
        return cur;
    }

}
