public class Solution036 {
    public boolean isValidSudoku(char[][] board) {
        boolean [][]row = new boolean[9][9];
        boolean [][]col = new boolean[9][9];
        boolean [][]cell = new boolean[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] >='1'&&board[i][j]<='9'){
                    int pos = board[i][j] - '1';
                    if(row[i][pos]||col[pos][j]||cell[(i/3)*3+j/3][pos])
                        return false;
                    row[i][pos]=col[pos][j]=cell[(i/3)*3+j/3][pos]=true;
                }
            }
        }
        return true;
    }
}
