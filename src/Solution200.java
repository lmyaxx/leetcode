public class Solution200 {
    public int numIslands(char[][] grid) {
        int res =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    fill(grid,i,j);
                }
                res++;
            }
        }
        return res;
    }

    private void fill(char[][] grid,int x,int y){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length)
            return;
        else{
            if(grid[x][y]=='1'){
                grid[x][y]='0';
                fill(grid,x-1,y);
                fill(grid,x+1,y);
                fill(grid,x,y-1);
                fill(grid,x,y+1);
            }

        }
    }
}
