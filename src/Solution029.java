public class Solution029 {
    public int divide(int dividend, int divisor) {
        int sign = (dividend^divisor) < 0 ? -1: 1;
        if(dividend==Integer.MIN_VALUE ){
            if(divisor==-1)
                return Integer.MAX_VALUE;
            if(divisor==1)
                return Integer.MIN_VALUE;
        }
        long x = Math.abs((long)dividend), y= Math.abs((long)divisor),i=1;
        int result = 0;
        while(y<x){
            y=y<<1;
            i=i<<1;
        }
        while(i>0){
            if(x>=y){
                result += i;
                x-=y;
            }
            i=i>>1;
            y=y>>1;
        }
        return sign*result;
    }
}
