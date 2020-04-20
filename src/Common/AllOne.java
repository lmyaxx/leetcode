package Common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author : Chad li
 * @Date : 2020/4/16 18:02
 * @Version 1.0
 */
public class AllOne {

    private Bucket head;
    private Bucket tail;
    private Map<Integer,Bucket> keyBucketMap;
    private Map<String,Integer> keyCountMap;

    private class Bucket{
        int count;
        Set<String> keys;
        Bucket next;
        Bucket pre;
        public Bucket(int count){
            this.count = count;
            keys = new HashSet<>();
        }
    }

    /** Initialize your data structure here. */
    public AllOne() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.pre = head;
        keyBucketMap = new HashMap<>();
        keyCountMap = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(keyCountMap.containsKey(key)){
            changeKey(key,1);
        } else {
            keyCountMap.put(key,1);
            Bucket newBucket = keyBucketMap.get(1);
            if(newBucket==null){
                newBucket = new Bucket(1);
                addBucketAfter(head,newBucket);
                keyBucketMap.put(1,newBucket);
            }
            newBucket.keys.add(key);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(keyCountMap.containsKey(key)){
            int count = keyCountMap.get(key);
            if(count==1){
                Bucket cur = keyBucketMap.get(count);
                cur.keys.remove(key);
                if(cur.keys.size()==0){
                    removeBucket(cur);
                    keyBucketMap.remove(cur.count);
                }
                keyCountMap.remove(key);
            }else{
                changeKey(key,-1);
            }
        }
    }

    private void changeKey(String key, int offset){
        int count = keyCountMap.get(key);
        keyCountMap.put(key,count+offset);
        Bucket curBucket = keyBucketMap.get(count);
        Bucket newBucket = keyBucketMap.get(count+offset);
        if(newBucket==null){
            newBucket = new Bucket(count+offset);
            addBucketAfter(curBucket,newBucket);
            keyBucketMap.put(count+offset,newBucket);
        }
        newBucket.keys.add(key);
        curBucket.keys.remove(key);
        if(curBucket.keys.size()==0){
            removeBucket(curBucket);
            keyBucketMap.remove(curBucket.count);
        }
    }

    private void addBucketAfter(Bucket cur, Bucket toAdd){
        toAdd.pre = cur;
        toAdd.next = cur.next;
        toAdd.next.pre = toAdd;
        cur.next = toAdd;
    }

    private void removeBucket(Bucket cur){
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.pre == head ? "" :tail.pre.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next==tail ? "":head.next.keys.iterator().next();
    }
}
