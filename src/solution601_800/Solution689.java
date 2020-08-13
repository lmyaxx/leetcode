package solution601_800;

import java.util.Arrays;

public class Solution689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] += sum[i] + nums[i];
        }
        int[] posLeft = new int[n];
        int[] posRight = new int[n];
        for(int i=k,sub = sum[k] - sum[0];i<n;i++){
            if(sum[i+1]-sum[i+1-k]>sub){
                posLeft[i] = i-k+1;
                sub = sum[i+1]-sum[i+1-k];
            }else{
                posLeft[i] = posLeft[i-1];
            }
        }
        posRight[n-k] = n-k;
        for (int i = n-k-1, sub = sum[n]-sum[n-k]; i >= 0; i--) {
            if (sum[i+k]-sum[i] >= sub) {
                posRight[i] = i;
                sub = sum[i+k]-sum[i];
            } else{
                posRight[i] = posRight[i+1];
            }
        }
        int[] res = new int[]{0,0,0};
        for(int i=k,sub =0 ;i<=n-2*k;i++){
            int l = posLeft[i-1], r = posRight[i+k];
            int total = sum[l+k] - sum[l] + sum[r+k] - sum[r] + sum[i+k] - sum[i];
            if(total>sub){
                sub = total;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;

    }


}
