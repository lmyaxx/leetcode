package solution801_1000;

public class Solution0845 {
    public int longestMountain(int[] A) {
        int len = A.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int ans = 0;
        for(int i = 1; i< len; i++){
            if(A[i-1]<A[i]){
                left[i] = left[i-1] + 1;
            }
        }
        for(int i = len - 2; i>=0; i--){
            if(A[i]>A[i+1]){
                right[i] = right[i+1] + 1;
            }
            if(left[i]>0&&right[i]>0){
                ans = Math.max(ans, left[i]+ right[i] + 1);
            }
        }
        return ans;
    }
}
