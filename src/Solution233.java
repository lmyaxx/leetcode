import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Chad li
 * @Date : 2020/3/14 17:00
 * @Version 1.0
 */
public class Solution233 {
    public int countDigitOne(int n) {
        if(n<=0){
            return 0;
        }
        Map<Integer,Integer> map  = new HashMap<>();
        map.put(0,0);
        int circle = 1;
        while (circle<n&&(circle*10)/10==circle){
            map.put(circle*10 - 1,map.get(circle-1)*10+circle);
            circle*=10;
        }
        return helper(n,map,circle);
    }

    private int helper(int n, Map<Integer,Integer> map,int circle){
        if(map.containsKey(n)){
            return map.get(n);
        }
        while(circle>n){
            circle/=10;
        }
        int result = 0;
        if(n/circle==1){
            result += n-circle+1;
        }else{
            result += circle;
        }
        result += (n/circle)*helper(circle-1,map,circle/10) + helper(n%circle,map,circle/10);
        return result;
    }

    public int countDigitOne1(int n){
        int count = 0;
        for(long pos = 1;pos<=n;pos*=10){
            long total = n/pos, rest = n%pos;
            count+= (total+2)/10*pos + (total%pos == 1? rest+1:0);
        }
        return count;
    }
}
