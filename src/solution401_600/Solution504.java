package solution401_600;

/**
 * @Author : Chad li
 * @Date : 2020/4/27 19:52
 * @Version 1.0
 */
public class Solution504 {
    public String convertToBase7(int num) {
        long res = num;
        int seven = 7;
        StringBuilder sb = new StringBuilder();
        while(Math.abs(res)>=seven){
            sb.insert(0,Math.abs(res % seven));
            res /= seven;
        }
        sb.insert(0,res);
        return sb.toString();
    }
}
