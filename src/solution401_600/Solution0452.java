package solution401_600;

import java.util.Arrays;

public class Solution0452 {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        int ans = 0;
        Arrays.sort(points,(a, b)->a[0] == b[0] ? Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0]));
        for(int i = 0; i< points.length; i++){
            ans ++;
            int right = points[i][1];
            for( ; i + 1<points.length && points[i+1][0]<= right; i++){
                right = Math.min(right, points[i+1][1]);
            }
        }
        return ans;
    }
}
