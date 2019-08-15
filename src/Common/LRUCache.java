package Common;

import java.util.Hashtable;

public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }
    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node){
        node.pre=head;
        node.post=head.post;
        head.post.pre = node;
        head.post=node;
    }
    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node){
        node.pre.post = node.post;
        node.post.pre=node.pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    // pop the current tail.
    private DLinkedNode popTail(){
        DLinkedNode end = this.tail.pre;
        removeNode(end);
        return end;
    }

    private Hashtable<Integer, DLinkedNode>
            cache = new Hashtable<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count=0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.pre = null;
        head.post = tail;
        tail.pre = head;
        tail.post = null;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(null==node) return -1;
        moveToHead(cache.get(key));
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(null==node){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            addNode(newNode);
            this.cache.put(key, newNode);
            count++;
            if(count>capacity){
                cache.remove(popTail().key);
                count--;
            }
        }else{
            node.value=value;
            moveToHead(node);
        }
    }
}
