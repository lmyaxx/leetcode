import Common.PeekingIterator;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author : Chad li
 * @Date : 2020/3/21 8:55
 * @Version 1.0
 */
public class Solution284 {
    @Test
    public void test(){
        List<Integer> res = new LinkedList<>();
        for(int i=0;i<100;i++){
            res.add(i);
        }
        PeekingIterator iter = new PeekingIterator(res.iterator());
        iter.hasNext();
        iter.next();
        iter.peek();
    }
}
