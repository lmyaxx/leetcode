/**
 * @Author : Chad li
 * @Date : 2020/3/10 8:58
 * @Version 1.0
 */
public class Solution201 {
    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        int num = 1;
        while(num<=m&&num>0){
            if((num&n)==num){
                if((n|(num-1)) - num<m){
                    result+=num;
                }
            }
            num=num<<1;
        }
        return result;
    }

    /**
     * 11010
     * 11011
     * 11100　　
     * 11101　　
     * 11110
     */
    public int rangeBitwiseAnd1(int m, int n) {
        int i = 0; // i means we have how many bits are 0 on the right
        while(m != n){
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m << i;
    }
}
