package solution001_200;

public class Solution191 {
    public int hammingWeight(int n) {
        int res = 0;
        while(n!=0){
            res+=n&1;
            n=n>>1;
        }
        return res;
    }
}
