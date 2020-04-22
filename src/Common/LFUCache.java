package Common;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @Author : Chad li
 * @Date : 2020/4/22 11:26
 * @Version 1.0
 */
public class LFUCache {

    private int min;

    private final int capacity;
    private final HashMap<Integer, Integer> keyToVal;
    private final HashMap<Integer, Integer> keyToCount;
    private final HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys;

    public LFUCache(int capacity) {
        this.min = -1;
        this.capacity = capacity;
        this.keyToVal = new HashMap<>();
        this.keyToCount = new HashMap<>();
        this.countToLRUKeys = new HashMap<>();
    }

    public int get(int key) {
       if(!keyToVal.containsKey(key)){
           return -1;
       }
       int count = keyToCount.get(key);
       countToLRUKeys.get(count).remove(key);
       if(min==count&&countToLRUKeys.get(count).size()==0){
           min++;
       }
       putCount(key,count+1);
       return keyToVal.get(key);
    }

    public void put(int key, int value) {
       if(capacity<=0){
           return;
       }
       if(keyToVal.containsKey(key)){
           keyToVal.put(key,value);
           get(key);
           return;
       }
       if(keyToVal.size()>=capacity){
           evict(countToLRUKeys.get(min).iterator().next());
       }
       min = 1;
       keyToVal.put(key,value);
       putCount(key,min);
    }

    private void evict(int key) {
        keyToVal.remove(key);
        countToLRUKeys.get(min).remove(key);
    }

    private void putCount(int key, int count) {
        keyToCount.put(key,count);
        countToLRUKeys.computeIfAbsent(count,ignore->new LinkedHashSet<>());
        countToLRUKeys.get(count).add(key);
    }
}
