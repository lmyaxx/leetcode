/**
 * @Author : Chad li
 * @Date : 2020/5/7 21:25
 * @Version 1.0
 */
public class Solution552 {

    static final int mod = 1000000007;
    public int checkRecord(int n) {
        long[] PorL = new long[n + 1]; // ending with P or L, no A
        long[] P = new long[n + 1]; // ending with P, no A
        PorL[0] = P[0] = 1; PorL[1] = 2; P[1] = 1;
        for(int i=2;i<=n;i++){
            P[i] = PorL[i-1];
            PorL[i] = (P[i-2] + P[i-1] + P[i])%mod;
        }
        long res = PorL[n];
        for(int i=0;i<n;i++){
            long s = (PorL[i] * PorL[n - i - 1]) % mod;
            res = (res + s) % mod;
        }
        return (int) res ;
    }
}
