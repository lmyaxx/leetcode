package solution001_200;

public class Solution190 {
    public int reverseBits(int n) {
        int res=0,count=32;
        while(count-->0){
            res=res<<1;
            if((n&1)==1)
                res|=1;
            n=n>>1;
        }
        return res;
    }
}
