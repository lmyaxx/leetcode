package solution201_400;

/**
 * @Author : Chad li
 * @Date : 2020/1/3 22:17
 * @Version 1.0
 */
public class Solution326 {
    public boolean isPowerOfThree(int n) {
        // for(int i = 1;i>0&&i<=n; i*=3){
        //     if(i==n)
        //         return true;
        // }
        // return false;

        // 1162261467 is 3^19,  3^20 is bigger than int
        return ( n>0 &&  1162261467%n==0);
    }
}
