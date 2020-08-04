package solution201_400;

public class Solution289 {
//    Any live cell with fewer than two live neighbors dies, as if caused by under-population.
//  Any live cell with two or three live neighbors lives on to the next generation.
//  Any live cell with more than three live neighbors dies, as if by over-population..
//  Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

    //live to die : 2
    //live to live: 1
    //die to live : 3
    //die to die : 0
    public void gameOfLife(int[][] board) {
        if(board.length==0) return;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                helper(board,i,j);
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==2){
                    board[i][j] = 0;
                    continue;
                }
                if(board[i][j]==3)
                    board[i][j]=1;
            }
        }

    }
    private void helper(int [][]board,int row,int col){
        int top=Math.max(row-1,0),left=Math.max(col-1,0);
        int down=Math.min(row+1,board.length-1),right=Math.min(col+1,board[0].length-1);
        int count = 0;
        for(int i=top;i<=down;i++){
            for(int j=left;j<=right;j++){
                if(i==row&&j==col)
                    continue;
                else{
                    if(board[i][j]==1||board[i][j]==2){
                        count++;
                    }
                }
            }
        }
        if(board[row][col]==0&&count==3){
            board[row][col]=3;
            return;
        }
        if(board[row][col]==1&&(count<2||count>3)){
            board[row][col] = 2;
            return;
        }
    }
}
