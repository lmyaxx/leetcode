import java.util.Arrays;

public class Solution1594 {
    public int maxProductPath(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        long[][] pos = new long[rows+1][cols+1];
        long[][] neg = new long[rows+1][cols+1];
        for(int i = 0; i<= rows; i++){
            Arrays.fill(pos[i],Long.MAX_VALUE);
            Arrays.fill(neg[i],Long.MAX_VALUE);
        }
        pos[0][1] = 1;
        pos[1][0] = 1;
        boolean isContainZero = false;
        for(int i = 0; i< rows; i++){
            for(int j = 0;j<cols; j++){
                if(grid[i][j] == 0){
                    isContainZero = true;
                    pos[i+1][j+1] = 0;
                    neg[i+1][j+1] = 0;
                }else if(grid[i][j] > 0){
                    long pos1 = Long.MIN_VALUE, pos2 = Long.MIN_VALUE, neg1 = Long.MAX_VALUE, neg2 =Long.MAX_VALUE;
                    if(pos[i][j+1] != Long.MAX_VALUE){
                        pos1 = grid[i][j] * pos[i][j+1];
                    }
                    if(pos[i+1][j] != Long.MAX_VALUE){
                        pos2 = grid[i][j] * pos[i+1][j];
                    }
                    if(neg[i][j+1] != Long.MAX_VALUE){
                        neg1 = grid[i][j] * neg[i][j+1];
                    }
                    if(neg[i+1][j] != Long.MAX_VALUE){
                        neg2 = grid[i][j] * neg[i+1][j];
                    }
                    long max = Math.max(pos1, pos2);
                    if(max != Long.MIN_VALUE){
                        pos[i+1][j+1] = max ;
                    }
                    long min = Math.min(neg1,neg2);
                    if(min != Long.MAX_VALUE){
                        neg[i+1][j+1] = min ;
                    }
                    // System.out.println(i + " " + j + "  " + pos[i+1][j+1] + "  " + neg[i+1][j+1] + "  " );
                }else{
                    long pos1 = Long.MIN_VALUE, pos2 = Long.MIN_VALUE, neg1 = Long.MAX_VALUE,  neg2 =Long.MAX_VALUE;
                    if(neg[i][j+1] != Long.MAX_VALUE){
                        pos1 = grid[i][j] * neg[i][j+1];
                    }
                    if(neg[i+1][j] != Long.MAX_VALUE){
                        pos2 = grid[i][j] * neg[i+1][j];
                    }
                    if(pos[i][j+1] != Long.MAX_VALUE){
                        neg1 = grid[i][j] * pos[i][j+1];
                    }
                    if(pos[i+1][j] != Long.MAX_VALUE){
                        neg2 = grid[i][j] * pos[i+1][j];
                    }
                    long max = Math.max(pos1, pos2);
                    if(max != Long.MIN_VALUE){
                        pos[i+1][j+1] = max ;
                    }
                    long min = Math.min(neg1,neg2);
                    if(min != Long.MAX_VALUE){
                        neg[i+1][j+1] = min ;
                    }
                }
            }
        }
        if(pos[rows][cols] != Long.MAX_VALUE){
            // System.out.println(111);
            return (int)(pos[rows][cols] % 1000_000_007);
        }
        if(isContainZero){
            return 0;
        }
        return -1;
    }
}
