/**
 * @Author : Chad li
 * @Date : 2020/3/18 13:42
 * @Version 1.0
 */
public class Solution263 {
    public boolean isUgly(int num) {
        if(num<=0) {
            return false;
        }
        while(num!=1&&num%2==0){
            num/=2;
        }
        while(num!=1&&num%3==0){
            num/=3;
        }
        while(num!=1&&num%5==0){
            num/=5;
        }
        return num==1;
    }
}
