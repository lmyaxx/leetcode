package solution001_200;

import java.util.ArrayList;
import java.util.List;

public class Solution089 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i=0,total=(int)Math.pow(2,n);i<total;i++){
            result.add((i>>1)^i);
        }
        return result;
    }
}
