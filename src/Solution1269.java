import java.util.Arrays;

public class Solution1269 {
    public int numWays(int steps, int arrLen) {
        int len = Math.min(steps/2 + 1,arrLen) ;
        int[] last = new int[len];
        int[] next = new int[len];
        next[0] = 1;
        for(int i=1;i<=steps;i++){
            int[] temp  = last;
            last = next;
            next = temp;
            for(int j=0;j< len; j++){
                next[j] = last[j];
                if(j-1>=0){
                    next[j] = (next[j] + last[j-1])%1000_000_007;
                }
                if(j+1<len){
                    next[j] = (last[j+1]+next[j])%1000_000_007;
                }
            }
            // System.out.println(Arrays.toString(next));
        }
        return next[0];
    }
}
