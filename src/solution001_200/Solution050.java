package solution001_200;

public class Solution050 {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n<0) return myPow(1/x,-(n+1))*1/x;
        return n%2 != 1 ? myPow(x*x,n/2) : x*myPow(x*x,n/2);
    }

    public double myPow1(double x, int n) {
        if(n<0) return myPow(1/x,-(n+1))*1/x;
        double result=0;
        while(n>0){
            if((n&1)==1)
                result*=x;
            x*=x;
            n=n>>1;
        }
        return result;
    }
}
