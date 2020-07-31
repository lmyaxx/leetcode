public class Solution1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for(int i=1;i<points.length;i++){
            int x = Math.abs(points[i][0]-points[i-1][0]);
            int y = Math.abs(points[i][1]-points[i-1][1]);
            int dia = Math.min(x,y);
            int vh = Math.max(x-dia,y-dia);
            res += dia + vh;
        }
        return res;
    }
}
