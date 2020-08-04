package solution001_200;

import Common.ListNode;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution023 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result=new ListNode(-1),cur,cur1;
        //HashMap（o(1)） is faster than TreeMap（o(logn)），
        //user map to storage the a circle link
        Map<Integer,ListNode> map = new TreeMap<>();
        for(ListNode node:lists){
            while(node!=null){
                cur = node;
                node =node.next;
                //make a circle
                cur.next = cur;
                if(map.containsKey(cur.val)){
                    //make the new end target to the head
                    cur.next = map.get(cur.val).next;
                    //make the first one to be the end
                    map.put(cur.val,cur);
                }else{
                    map.put(cur.val,cur);
                }
            }
        }
        cur = result;
        for(ListNode node:map.values()){
            cur.next = node.next;
            cur =node;
        }
        cur.next = null;
        return  result.next;
    }
    public ListNode mergeKLists1(ListNode[] lists) {
        int len = lists.length;
        while(len>1){
            for(int i=0;i<len/2;i++){
                lists[i] = mergeTwoSorted(lists[i],lists[len-1-i]);
                lists[len-1-i]=null;
            }
            len = (len+1) / 2 ;
        }
        return  len==0? null: lists[0];
    }


    public ListNode mergeTwoSorted(ListNode l1,ListNode l2){
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                cur = cur.next = l2;
                l2 = l2.next;
            }else{
                cur = cur.next = l1;
                l1 = l1.next;
            }
        }
        if(l1==null) cur.next=l2;
        if(l2==null) cur.next=l1;
        return pre.next;
    }
}
