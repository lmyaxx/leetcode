package solution001_200;

public class Solution037 {
    public void solveSudoku(char[][] board) {
        boolean [][]row = new boolean[9][9];
        boolean [][]col = new boolean[9][9];
        boolean [][]cell = new boolean[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] >='1'&&board[i][j]<='9'){
                    int pos = board[i][j] - '1';
                    row[i][pos]=col[pos][j]=cell[(i/3)*3+j/3][pos]=true;
                }
            }
        }
        fill_cell(0,0,row,col,cell,board);
    }

    public boolean fill_cell(int i,int j,boolean [][]row,boolean [][]col,boolean [][]cell,char[][] board){
        while(i<9&&board[i][j] != '.'){
            i = i + (j + 1)/ 9;
            j=(j + 1) % 9;
        }
        if(i==9)
            return true;
        for(int pos=0;pos<9;pos++){
            if(!(row[i][pos]||col[pos][j]||cell[(i/3)*3+j/3][pos])){
                board[i][j] = (char)(pos + '1');
                row[i][pos]=col[pos][j]=cell[(i/3)*3+j/3][pos]=true;
                if(fill_cell(i,j,row,col,cell,board))
                    return true;
                else{
                    board[i][j] = '.';
                    row[i][pos]=col[pos][j]=cell[(i/3)*3+j/3][pos]=false;
                }
            }
        }
        return false;
    }
}
