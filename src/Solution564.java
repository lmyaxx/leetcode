import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author : Chad li
 * @Date : 2020/5/9 21:34
 * @Version 1.0
 */
public class Solution564 {
    public String nearestPalindromic(String n) {
        int len = n.length();
        if(len<=1){
            return String.valueOf(Long.parseLong(n)-1);
        }
        boolean isEven = (len&1)==0;
        String former = isEven ? n.substring(0,len/2): n.substring(0,len/2 + 1);
        String newBigFormer = String.valueOf(Long.parseLong(former) + 1);
        String newSmallFormer = String.valueOf(Long.parseLong(former)-1);
        Long[] res = new Long[]{
                helper(isEven,former,former,len),
                helper(isEven,former,newBigFormer,len),
                helper(isEven,former,newSmallFormer,len)
        };
        long v = Long.parseLong(n);
        Comparator<Long> comparator = (a, b)->{
            int compare = Long.compare(Math.abs(a - v),Math.abs(b-v));
            if(compare == 0){
                return a>=b?1:-1;
            }else{
                return compare;
            }
        };
        Arrays.sort(res,comparator);
        return String.valueOf(res[0] == v ? res[1] : res[0]);
    }

    private long helper(boolean isEven,String former, String newFormer,int len){
        long answer;
        if(newFormer.length()>former.length()){
            answer =  (long)Math.pow(10,len) + 1;
        }else if(newFormer.length()<former.length()){
            answer =  (long)Math.pow(10,len-1)-1;
        }else{
            if(isEven){
                answer = Long.parseLong(newFormer + new StringBuilder(newFormer).reverse().toString());
            }else{
                answer = Long.parseLong(newFormer + new StringBuilder(newFormer).reverse().substring(1));
            }
        }
        return answer==0 ? 9:answer;
    }
}
