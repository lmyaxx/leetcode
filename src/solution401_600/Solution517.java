package solution401_600;

import java.util.Arrays;

/**
 * @Author : Chad li
 * @Date : 2020/5/4 9:18
 * @Version 1.0
 */
public class Solution517 {
    public int findMinMoves(int[] machines) {
        int total = 0, avg = 0, len = machines.length;
        for(int num:machines){
            total+=num;
        }
        if(total%len!=0){
            return -1;
        }
        avg = total / len;
        int  cnt = 0, max = 0;
        for(int load: machines){
            cnt += load-avg; //load-avg is "gain/lose"
            max = Math.max(Math.max(max, Math.abs(cnt)), load-avg);
        }
        return max;
    }
}
