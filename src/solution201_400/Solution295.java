package solution201_400;

import Common.MedianFinder;
import org.junit.Test;

public class Solution295 {
    @Test
    public void test_solution(){
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}
