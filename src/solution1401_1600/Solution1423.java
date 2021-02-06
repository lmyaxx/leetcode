package solution1401_1600;

/**
 * @author: chad li
 * @date: 2021/2/6
 * @discription:
 */
public class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        k = cardPoints.length - k;
        int cur = 0, sum = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            sum += cardPoints[i];
            cur += cardPoints[i];
        }
        min = Math.min(min, cur);
        for(int i = k; i<cardPoints.length; i++){
            sum += cardPoints[i];
            cur += cardPoints[i] - cardPoints[i-k];
            min = Math.min(cur, min);
        }
        return sum - min;
    }
}
