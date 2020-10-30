package solution401_600;

public class Solution0463 {
    public int islandPerimeter(int[][] grid) {
        int rs = grid.length, cs = grid[0].length, ans = 0;
        for(int r = 0; r < rs; r++){
            int count = 0;
            for(int c = 0; c < cs; c++){
                if(grid[r][c] == 1){
                    count = 1;
                }else{
                    ans += count * 2;
                    count = 0;
                }
            }
            ans += count * 2;
        }
        for(int c = 0; c < cs; c++ ){
            int count = 0;
            for (int r = 0; r < rs; r++) {
                if(grid[r][c] == 1){
                    count = 1;
                }else{
                    ans += count * 2;
                    count = 0;
                }
            }
            ans += count * 2;
        }
        return ans;
    }
}
