import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author : Chad li
 * @Date : 2020/4/5 21:15
 * @Version 1.0
 */
public class Solution407 {

    class Cell implements Comparable<Cell> {
        public int row, col, height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        @Override
        public int compareTo(Cell o) {
            return this.height - o.height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        PriorityQueue<Cell> priorityQueue = new PriorityQueue<>();
        int height = heightMap.length, width = heightMap[0].length;
        boolean[][] visited = new boolean[height][width];
        for(int i=0;i<height;i++){
            priorityQueue.add(new Cell(i,0,heightMap[i][0]));
            priorityQueue.add(new Cell(i,width-1,heightMap[i][width-1]));
            visited[i][0] = true;
            visited[i][width-1] = true;
        }
        for(int j=1;j<width-1;j++){
            priorityQueue.add(new Cell(0,j,heightMap[0][j]));
            priorityQueue.add(new Cell(height-1,j,heightMap[height-1][j]));
            visited[0][j] = true;
            visited[height-1][j] = true;
        }
        int res = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!priorityQueue.isEmpty()){
            Cell cell = priorityQueue.poll();
            for (int[] dir : dirs) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];
                if (row >= 0 && row < height && col >= 0 && col < width && !visited[row][col]) {
                    visited[row][col] = true;
                    res += Math.max(0, cell.height - heightMap[row][col]);
                    priorityQueue.offer(new Cell(row, col, Math.max(heightMap[row][col], cell.height)));
                }
            }
        }
        return res;
    }
}
