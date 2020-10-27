import java.util.*;

public class Solution1631 {
    /**
     * rows == heights.length
     * columns == heights[i].length
     * 1 <= rows, columns <= 100
     * 1 <= heights[i][j] <= 106
     */
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0,0,0});
        dist[0][0] = 0;
        while (!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            if(cur[1] == m - 1 && cur[2] == n - 1){
                return dist[m-1][n-1];
            }
            for(int i = 0 ; i < 4; i++){
                int nr = cur[1] + DIR[i], nc = cur[2] + DIR[i+1];
                if(nr>=0&&nr<m&&nc>=0&&nc<n){
                    int dis = Math.max(cur[0], Math.abs(heights[nr][nc]-heights[cur[1]][cur[2]]));
                    if(dis < dist[nr][nc] ){
                        minHeap.offer(new int[]{dis, nr, nc});
                        dist[nr][nc] = dis;
                    }
                }
            }
        }
        return 0; // Unreachable code, Java require to return interger value.
    }


    private int[] d = {0, 1, 0, -1, 0};
    public int minimumEffortPath1(int[][] heights) {
        int lo = 0, hi = 1_000_000;
        while (lo < hi) {
            int effort = lo + (hi - lo) / 2;
            if (isPath(heights, effort)) {
                hi = effort;
            }else {
                lo = effort + 1;
            }
        }
        return lo;
    }
    private boolean isPath(int[][] h, int effort) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[2]);
        int m = h.length, n = h[0].length;
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int r = pos[0], c = pos[1];
            if(r == m - 1 && c == n -1){
                return true;
            }
            for(int i=0; i< 4; i++){
                int nr = r + d[i], nc = c + d[i+1];
                if(nr>=0 && nr < m && nc >=0&&nc < n
                         && Math.abs(h[nr][nc]-h[r][c])<=effort && seen.add(nr * n + nc)){
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
        return false;
    }
}
