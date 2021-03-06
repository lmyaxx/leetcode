package solution1001_1200;

public class Solution1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int left = A[0] + 0;
        int res = 0;
        for(int j=1;j<A.length;j++){
            res = Math.max(res,left+A[j]-j);
            left = Math.max(left,A[j]+j);
        }
        return res;
    }
}
