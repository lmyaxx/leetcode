package solution601_800;

import java.util.Stack;

public class Solution0738 {
    public int monotoneIncreasingDigits(int N) {
        if(N < 10){
            return N;
        }
        char[] num = Integer.toString(N).toCharArray();
        for(int i = num.length-2; i>=0; i --){
            if(num[i] <= num[i+1]){
                continue;
            }else{
                num[i]--;
                for(int k = i + 1; k< num.length; k++){
                    num[k] = '9';
                }
            }
        }
        int ans = 0;
        for(int i = 0; i<num.length; i++){
            ans = ans* 10 + num[i] - '0';
        }
        return ans;
    }
}
