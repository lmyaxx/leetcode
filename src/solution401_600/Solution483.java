package solution401_600;

import java.math.BigInteger;

/**
 * @Author : Chad li
 * @Date : 2020/4/30 14:45
 * @Version 1.0
 */
public class Solution483 {
    public String smallestGoodBase(String nn) {
        long n = Long.parseLong(nn);
        long res = 0;
        for(int k=(int)(Math.log(n + 1) / Math.log(2));k>=2;k--){
            long s = 2, e = n;
            while(s<=e){
                long mid = (s+e)/2;
                BigInteger left = BigInteger.valueOf(mid);
                left = left.pow(k).subtract(BigInteger.ONE);
                BigInteger right = BigInteger.valueOf(n).multiply(BigInteger.valueOf(mid).subtract(BigInteger.ONE));
                int cmp = left.compareTo(right);
                if(cmp==0){
                   return ""+mid;
                }else if(cmp>0){
                    e = mid-1;
                } else{
                    s = mid +1;
                }
            }
        }
        return ""+res;
    }
}
