import Common.SummaryRanges;
import org.junit.Test;

/**
 * @Author : Chad li
 * @Date : 2020/4/1 17:00
 * @Version 1.0
 */
public class Solution352 {
    @Test
    public void test(){
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        summaryRanges.addNum(5);
        summaryRanges.addNum(3);
        summaryRanges.getIntervals();
        summaryRanges.addNum(6);
        summaryRanges.getIntervals();
        summaryRanges.addNum(4);
        summaryRanges.getIntervals();
        summaryRanges.addNum(2);
        summaryRanges.getIntervals();
    }
}
