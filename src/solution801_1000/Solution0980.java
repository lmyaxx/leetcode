package solution801_1000;

/**
 * @author: chad li
 * @date: 2020/12/19
 * @discription:
 */
public class Solution0980 {
    public int uniquePathsIII(int[][] grid) {
        int sy = -1, sx = -1, n = 0, rows = grid.length, cols = grid[0].length;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if(grid[y][x] == 0){
                    n++;
                }else if(grid[y][x]==1){
                    sy = y;
                    sx = x;
                }
            }
        }
        grid[sy][sx] = 0;
        n++;
        return dfs(grid, sy, sx, n);
    }

    private int dfs(int[][]grid, int y, int x, int n){
        if(y<0 || x <0 || y>=grid.length || x >= grid[0].length){
            return 0;
        }
        if(grid[y][x] == 2 && n==0){
            return 1;
        }else if(grid[y][x] == 0){
            int ans = 0;
            grid[y][x] = -1;
            ans += dfs(grid,y+1,x,n-1) +
                    dfs(grid, y-1,x,n-1)+
                    dfs(grid,y,x+1,n-1)+
                    dfs(grid,y,x-1, n - 1);
            grid[y][x] = 0;
            return ans;
        }else{
            return 0;
        }
    }
}
