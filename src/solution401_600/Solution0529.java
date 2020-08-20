package solution401_600;

public class Solution0529 {
    private int[] x = {1, 1, 1, 0, -1, -1, -1, 0};
    private int[] y = {1, 0, -1, -1, -1, 0, 1, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
        helper(board,click[0], click[1]);
        return board;
    }

    private void helper(char[][] board, int row, int col){
        if(board[row][col] == 'M'){
            board[row][col] = 'X';
        }else if(board[row][col] == 'E' || (board[row][col]> '0' && board[row][col] < '9')){
            int count = countNearBy(board, row, col);
            if(count != 0){
                board[row][col] = (char)('0' + count);
            }else{
                board[row][col] = 'B';
                for(int i=0; i< 8; i++){
                    int nx = row + x[i], ny = col + y[i];
                    if(inbound(board, nx, ny)&& board[nx][ny] != 'M' && board[nx][ny] != 'B'){
                        helper(board,nx,ny);
                    }
                }
            }
        }
    }

    private int countNearBy(char[][] board, int row, int col){
        int count = 0;
        for(int i = 0; i < 8; i++){
            int nx = row + x[i], ny = col + y[i];
            if(inbound(board, nx, ny)&&board[nx][ny] == 'M'){
                count++;
            }
        }
        return count;
    }

    private boolean inbound(char[][] board, int row, int col){
        return !(row < 0 || row >=board.length || col < 0 || col >= board[0].length);
    }
}
