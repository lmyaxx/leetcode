import javafx.util.Pair;

import java.util.*;

/**
 * @Author : Chad li
 * @Date : 2020/2/29 14:10
 * @Version 1.0
 */
public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count  = new int[26];
        for(char ch:tasks){
            count[ch-'A'] ++;
        }
        Arrays.sort(count);
        int i = 24;
        while(i>=0&&count[i]==count[i+1]){
            i--;
        }
        return Math.max(tasks.length, (count[25] - 1)*(n+1) + 25- i);
    }


}
