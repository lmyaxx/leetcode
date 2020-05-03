import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @Author : Chad li
 * @Date : 2020/5/3 16:08
 * @Version 1.0
 */
public class Solution446 {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        //dp[i].get(key) means the number of arithmetic sequences end with A[i] whose value of difference is "key",and the sequence is >=2;
        HashMap<Integer,Integer>[] dp = new HashMap[A.length];
        for(int i=0;i<A.length;i++){
            dp[i] = new HashMap<>();
            for(int j=0;j<i;j++){
                long diff = (long)A[i] - A[j];
                if(diff>Integer.MAX_VALUE||diff<=Integer.MIN_VALUE){
                    continue;
                }
                int d = (int) diff;
                int toAdd = dp[j].getOrDefault(d,0);
                //this is to solve the number with the same value
                int owned = dp[i].getOrDefault(d,0);
                dp[i].put(d, toAdd + owned + 1);

                res += toAdd;
            }
        }
        return res;
    }
}
