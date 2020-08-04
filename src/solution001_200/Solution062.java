package solution001_200;

import java.math.BigInteger;

public class Solution062 {
    public int uniquePaths(int m, int n) {
        BigInteger grid[][] = new BigInteger[m][n];
        for(int i=0;i<m;i++) grid[i][0]=BigInteger.valueOf(1);
        for(int i=0;i<n;i++) grid[0][i]=BigInteger.valueOf(1);
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++)
                grid[i][j]=grid[i-1][j].add(grid[i][j-1]);
        }
        return grid[m-1][n-1].intValue();
    }

    public int uniquePaths1(int m, int n) {
        int grid[] = new int[n];
        for(int i=0;i<n;i++) grid[i]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++)
                grid[j] +=grid[j-1];
        }
        return grid[n-1];
    }
    //排列组合
    public int uniquePaths2(int m, int n){
        int total = m + n - 2;
        int k = m - 1;
        long ans = 1;
        for (int i = 1; i <= k; i++) {
            ans = ans * (total - k + i) / i;
        }
        return (int)ans;
    }
}
