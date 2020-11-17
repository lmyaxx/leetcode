package solution1001_1200;

import java.util.PriorityQueue;

public class Solution1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return Math.abs(a[0]-r0) + Math.abs(a[1]-c0) - Math.abs(b[0] - r0) - Math.abs(b[1] - c0);
        });
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                pq.offer(new int[]{r,c});
            }
        }
        int[][] ans = new int[R * C][];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll();
        }
        return ans;
    }
}
