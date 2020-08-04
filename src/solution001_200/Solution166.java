package solution001_200;

import java.util.HashMap;
import java.util.Map;

public class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long numerator1 = numerator,denominator1=denominator;
        StringBuilder sb = new StringBuilder();
        if(numerator1!=0&&(numerator1^denominator1)<0)
            sb.append("-");
        numerator1=Math.abs(numerator1);
        denominator1=Math.abs(denominator1);

        sb.append(numerator1/denominator1);

        numerator1 = numerator1%denominator1;
        if(numerator1==0)
            return sb.toString();
        else sb.append(".");
        Map<Long,Integer> map =new HashMap<>();
        int index = sb.length();
        while(true){
            if(numerator1==0)
                return sb.toString();
            if(numerator1<denominator1)
                numerator1*=10;
            sb.append(numerator1/denominator1);
            map.put(numerator1/10,index++);
            numerator1 = numerator1%denominator1;
            if(map.containsKey(numerator1))
                break;
        }
        sb.append(")");
        sb.insert(map.get(numerator1),"(");
        return sb.toString();
    }
}
