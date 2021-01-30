package solution601_800;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author: chad li
 * @date: 2021/1/30
 * @discription:
 */
public class Solution0778 {
    int[] DIR = {0, 1, 0, -1, 0};
    int rows, cols;
    public int swimInWater(int[][] grid) {
        rows = grid.length; cols = grid[0].length;
        PriorityQueue<int[]> neighbors = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        Set<Integer> set = new HashSet<>();
        set.add(cast(0,1));
        set.add(cast(1,0));
        neighbors.add(new int[]{grid[0][1],0,1});
        neighbors.add(new int[]{grid[1][0],1,0});
        int height = grid[0][0];
        while(!neighbors.isEmpty()){
            int[] cur = neighbors.peek();
            if(cur[0]<=height){
                if(cur[1] == rows-1 && cur[2] == cols - 1){
                    return height;
                }
                neighbors.poll();
                visited[cur[1]][cur[2]] = true;
                for(int i = 0; i < 4; i++){
                    int nr = cur[1] + DIR[i], nc = cur[2] + DIR[i+1];
                    if(inBound(nr,nc) && !visited[nr][nc] && !set.contains(cast(nr,nc))){
                        neighbors.offer(new int[]{grid[nr][nc], nr, nc});
                        set.add(cast(nr,nc));
                    }
                }
            }else{
                height = cur[0];
            }
        }
        return height;
    }

    private int cast(int row, int col){
        return row * cols + col;
    }

    private boolean inBound(int row, int col){
        return row>=0 && col>=0 && row < rows && col < cols;
    }

}
