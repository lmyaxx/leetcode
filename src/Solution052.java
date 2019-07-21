import java.util.ArrayList;
import java.util.List;

public class Solution052 {
    public int totalNQueens(int n) {
        int rows[] = new int [n];
        boolean judge1[] = new boolean [2*n-1];
        boolean judge2[] = new boolean [2*n-1];
        for(int i=0;i<n;i++){
            rows[i]=i;
        }
        List<List<String>> result = new ArrayList<>();
        return getQueens(0,n,rows,judge1,judge2);

    }

    private int getQueens(int start,int n,int [] row,boolean [] judge1,boolean [] judge2){
        if(start==n){
            return 1;
        }
        int sum=0;
        for(int i=start;i<n;i++){
            int x =start-row[i]+n-1,y=row[i]+start;
            if(judge1[x]||judge2[y])
                continue;
            judge1[x]=judge2[y] =true;
            swap(row,start,i);
            sum+=getQueens(start+1,n,row,judge1,judge2);
            swap(row,start,i);
            judge1[x]=judge2[y] =false;
        }
        return sum;
    }

    private void swap(int []row,int x,int y){
        int temp = row[x];
        row[x] = row[y];
        row[y] = temp;
    }

    private boolean isDiagonal(int x,int y,int m,int n){
        return Math.abs((x-m)*1.0/(y-n))==1;
    }

    public int totalNQueens1(int n) {
        return dfs(0, n, 0, 0, 0);
    }

    private int dfs(int row, int n, int column, int diag, int antiDiag) {
        if (row == n) return 1;
        int sum=0;
        for (int i = 0; i < n; ++i) {
            boolean isColSafe = ((1 << i) & column) == 0;
            boolean isDiagSafe = ((1 << (n - 1 + row - i)) & diag) == 0;
            boolean isAntiDiagSafe = ((1 << (row + i)) & antiDiag) == 0;
            if (isColSafe && isDiagSafe && isAntiDiagSafe) {
                sum+=dfs(row + 1, n, (1 << i) | column, (1 << (n - 1 + row - i)) | diag, (1 << (row + i)) | antiDiag);
            }
        }
        return sum;
    }
}
