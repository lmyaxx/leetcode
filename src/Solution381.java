import Common.RandomizedCollection;
import org.junit.Test;

/**
 * @Author : Chad li
 * @Date : 2020/4/4 21:44
 * @Version 1.0
 */
public class Solution381 {
    @Test
    public void testSolution381(){
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(1);
        randomizedCollection.insert(3);
        randomizedCollection.getRandom();
        randomizedCollection.remove(3);
    }
}
