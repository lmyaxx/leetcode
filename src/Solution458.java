/**
 * @Author : Chad li
 * @Date : 2020/4/18 11:24
 * @Version 1.0
 */
public class Solution458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 1;
        while(Math.pow((minutesToTest/minutesToDie+1),pigs)<buckets){
            pigs++;
        }
        return pigs;
    }
}
