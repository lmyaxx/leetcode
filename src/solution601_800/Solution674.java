package solution601_800;

import java.util.*;

public class Solution674 {
    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> treeHeights = getAllTreeHeights(forest);
        Collections.sort(treeHeights, (o1, o2) -> {
            return o1[2] - o2[2];
        });
        int res = 0,col = 0, row = 0;
        while (!treeHeights.isEmpty()){
            int[] curTree = treeHeights.remove(0);
            int steps = getMinimumSteps(forest,row,col,curTree[0],curTree[1]);
            if(steps==-1){
                return -1;
            }
            row = curTree[0];
            col = curTree[1];
            res += steps;
        }
        return res;
    }

    private int getMinimumSteps(List<List<Integer>> forest, int row, int col, int d_row, int d_col) {
        int minSteps = 0;
        int rows = forest.size(),cols=forest.get(0).size();
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int[] cur = queue.poll();
                if(cur[0]==d_row&&cur[1]==d_col){
                    return minSteps;
                }
                for (int[] direction: directions) {
                    int nx = cur[0] + direction[0];
                    int ny = cur[1] + direction[1];
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols &&
                            !visited[nx][ny] && forest.get(nx).get(ny) != 0) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            minSteps++;
        }
        return -1;
    }

    private List<int[]> getAllTreeHeights(List<List<Integer>> forest){
        List<int[]> treeHeights = new LinkedList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                int val = forest.get(i).get(j);
                if(val>1){
                     treeHeights.add(new int[]{i,j,val});
                }
            }
        }
        return treeHeights;
    }
}
