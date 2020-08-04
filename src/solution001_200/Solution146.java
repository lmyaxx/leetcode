package solution001_200;

import Common.LRUCache;
import org.junit.Test;

//  LRUCache
public class Solution146 {
    @Test
    public void test(){
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));// returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3 (not found)
        System.out.println(cache.get(4)); // returns 4 (not found)
    }
}
