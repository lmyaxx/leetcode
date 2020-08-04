package solution201_400;

import java.util.Arrays;

/**
 * @Author : Chad li
 * @Date : 2020/4/2 16:43
 * @Version 1.0
 */
public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length==0){
            return 0;
        }
        Arrays.sort(envelopes,(a,b)->a[0]-b[0]==0?b[1]-a[1]:a[0]-b[0]);
        int res = 1;
        //keep high ascend
        int[] high = new int[envelopes.length];
        high[0] = envelopes[0][1];
        for(int i=1;i<envelopes.length;i++){
            int left = 0, right = res-1;
            while(left<=right){
                int mid = (left+right)/2;
                if(envelopes[i][1]>high[mid]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            high[right+1] = envelopes[i][1];
            if(right+1==res){
                res ++;
            }
        }
        return res;
    }
}
