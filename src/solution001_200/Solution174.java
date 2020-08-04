package solution001_200;

public class Solution174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0) return 0;
        int height=dungeon.length,width=dungeon[0].length;
        if(dungeon[height-1][width-1]>0) dungeon[height-1][width-1]=0;
        for(int row=height-2;row>=0;row--){
            dungeon[row][width-1]+=dungeon[row+1][width-1];
            if(dungeon[row][width-1]>0) dungeon[row][width-1] = 0;
        }
        for(int col=width-2;col>=0;col--){
            dungeon[height-1][col]+=dungeon[height-1][col+1];
            if(dungeon[height-1][col]>0) dungeon[height-1][col]=0;
        }
        for(int row=height-2;row>=0;row--){
            for(int col=width-2;col>=0;col--){
                dungeon[row][col] +=Math.max(dungeon[row+1][col],dungeon[row][col+1]);
                if(dungeon[row][col]>0) dungeon[row][col]=0;
            }
        }
        if(dungeon[0][0]<0)
            return -dungeon[0][0] + 1;
        else return 1;
    }
}
