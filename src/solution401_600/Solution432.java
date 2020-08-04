package solution401_600;

import Common.AllOne;
import org.junit.Test;

/**
 * @Author : Chad li
 * @Date : 2020/4/18 11:21
 * @Version 1.0
 */
public class Solution432 {
    @Test
    public void testAllOne(){
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        allOne.getMaxKey();
        allOne.getMinKey();
        allOne.dec("hello");
    }
}
