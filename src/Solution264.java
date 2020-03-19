/**
 * @Author : Chad li
 * @Date : 2020/3/19 8:04
 * @Version 1.0
 */
public class Solution264 {
    public int nthUglyNumber(int n) {
        long[] count = new long[1690];
        count[0] = 1;
        for(int right=1,left = 0;right<n;right++){
            long min = Integer.MAX_VALUE;
            for(int j=left;j<right;j++){
                if(count[j]*5>count[right-1]){
                    min = Math.min(count[j]*5,min);
                }else{
                    left = j+1;
                }
                if(count[j]*3>count[right-1]){
                    min = Math.min(count[j]*3,min);
                }
                if(count[j]*2>count[right-1]){
                    min = Math.min(count[j]*2,min);
                }
            }
            count[right] = min;
        }
        return  (int)count[n-1];
    }

    public int nthUglyNumber1(int n) {
        int[] count = new int[n];
        int index2=0,index3=0,index5=0;
        int factor2 = 2,factor3= 3,factor5 =5;
        count[0] = 1;
        for(int i=1;i<n;i++){
            int min = Math.min(factor2,Math.min(factor3,factor5));
            count[i] = min;
            if(min==factor2){
                factor2 = 2*count[++index2];
            }
            if(min==factor3){
                factor3 = 3*count[++index3];
            }
            if(min==factor5){
                factor5 = 5*count[++index5];
            }
        }
        return  count[n-1];
    }
}
