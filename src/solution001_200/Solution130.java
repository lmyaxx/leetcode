package solution001_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution130 {
    public void solve(char[][] board) {
        if(board==null||board.length==0) return;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='O')
                    helper(i,j,board);
                if(board[i][j]=='t')
                    board[i][j]='O';
            }
        }
    }

    private void helper(int i,int j,char [][]board){
        List<int []> memo = new ArrayList<>();
        boolean find = false;
        memo.add(new int[]{i,j});
        board[i][j] = 't';
        for(int k=0;k<memo.size();k++){
            int cur[] = memo.get(k);
            if(!find){
                if(cur[0]==0||cur[0]==board.length-1||cur[1]==0||cur[1]==board[0].length-1)
                    find=true;
            }
            if(cur[0]-1>=0&&board[cur[0]-1][cur[1]]=='O'){
                memo.add(new int[]{cur[0]-1,cur[1]});
                board[cur[0]-1][cur[1]]='t';
            }
            if(cur[0]+1<board.length&&board[cur[0]+1][cur[1]]=='O'){
                memo.add(new int[]{cur[0]+1,cur[1]});
                board[cur[0]+1][cur[1]]='t';
            }
            if(cur[1]-1>=0&&board[cur[0]][cur[1]-1]=='O'){
                memo.add(new int[]{cur[0],cur[1]-1});
                board[cur[0]][cur[1]-1]='t';
            }
            if(cur[1]+1<board[0].length&&board[cur[0]][cur[1]+1]=='O'){
                memo.add(new int[]{cur[0],cur[1]+1});
                board[cur[0]][cur[1]+1]='t';
            }
        }
        if(find)
            return ;
        else{
            for(int [] cur :memo){
                board[cur[0]][cur[1]] = 'X';
            }
        }
    }
}
