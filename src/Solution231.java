/**
 * @Author : Chad li
 * @Date : 2020/3/15 9:17
 * @Version 1.0
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        long num = n;
        return ((((num-1)|num)+1)>>1)==num;
    }
}
