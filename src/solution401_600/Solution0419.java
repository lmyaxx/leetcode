package solution401_600;

public class Solution0419 {
    public int countBattleships(char[][] board) {
        if(board==null||board.length==0||board[0].length==0){
            return 0;
        }
        int rows = board.length, cols = board[0].length;
        int res = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]!='X'){
                    continue;
                }
                int dir = getDirection(board,i,j,0);
                if(dir==0){
                    res++;
                }
                if(dir==1||dir==2){
                    int ni = i, nj = j,nd;
                    while(ni<rows&&nj<cols&&board[ni][nj]=='X'){
                        nd = getDirection(board,ni,nj,dir);
                        //when it meets 0, it means it comes to an end.
                        if(nd==0){
                            break;
                        }
                        //if the direction is not consistent with the former, it means it has at least on near ship.
                        if(nd!=dir){
                            res--;
                            break;
                        }
                        //go down
                        ni += dir==1 ? 1 : 0;
                        //go right
                        nj += dir==2 ? 1 : 0;
                    }
                    res++;
                }
            }
        }
        return res;
    }

    //1111: 1left 1up 1right 1down
    private int getDirection(char[][]board, int i, int j, int odir){
        //remove the from direction
        odir = odir<<2;
        odir = ~odir;
        int dir = 0;
        if(i+1<board.length&&board[i+1][j]=='X'){
            dir |= 1;
        }
        if(j+1<board[0].length&&board[i][j+1] == 'X'){
            dir |= 2;
        }
        if(i-1>=0&&board[i-1][j]=='X'){
            dir|= 4;
        }
        if(j-1>=0&&board[i][j-1]=='X'){
            dir|= 8;
        }
        return dir&odir;
    }
}
