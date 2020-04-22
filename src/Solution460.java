import Common.LFUCache;
import org.junit.Test;

/**
 * @Author : Chad li
 * @Date : 2020/4/22 14:14
 * @Version 1.0
 */
public class Solution460 {
    @Test
    public void test_LFUCache(){
        LFUCache lfuCache = new LFUCache(20);
        lfuCache.put(3,3);
        lfuCache.get(2);
    }
}
