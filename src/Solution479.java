/**
 * @Author : Chad li
 * @Date : 2020/4/28 10:43
 * @Version 1.0
 */
public class Solution479 {
    public int largestPalindrome(int n) {
        int upper = (int)(Math.pow(10,n) - 1), lower = upper / 10;
        for(int i= upper;i>lower;i--){
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            long p = Long.parseLong(i + sb.reverse().toString());
            for(long j= upper;j * j>p;j--){
                if(p%j==0) {
                    return (int) (p%1337);
                }
            }
        }
        return 9;
    }
}
