package solution001_200;

public class Solution079 {
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||word.length()==0) return false;
        int rows = board.length,cols=board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(helper(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char [][]board,String word,int row,int col,int index){
        if(index==word.length()) return true;
        if(row<0||col<0||row>=board.length||col>=board[0].length||board[row][col]!=word.charAt(index))
            return false;
        index++;
        char temp = board[row][col];
        board[row][col] = '\0';
        boolean result = helper(board, word, row+1, col, index)||helper(board, word, row, col+1, index)||
                helper(board, word, row-1, col, index)||helper(board, word, row, col-1, index);
        board[row][col] = temp;
        return result;
    }
}
