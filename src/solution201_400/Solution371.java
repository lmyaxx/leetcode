package solution201_400;

/**
 * @Author : Chad li
 * @Date : 2020/1/11 13:49
 * @Version 1.0
 */
public class Solution371 {
    public int getSum(int a, int b) {
        while(b!=0){
            a ^=b;
            b = (b^a)& b;
            b = b<<1;
        }
        return a;
    }
}
