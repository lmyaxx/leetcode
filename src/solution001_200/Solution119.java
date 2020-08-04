package solution001_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        Integer res[]=new Integer[rowIndex+1];
        for(int i=1;i<=rowIndex+1;i++){
            int temp = 1;
            for(int j=1;j<i-1;j++){
                res[j] = res[j] + temp;
                temp = res[j] -temp;
            }
            res[i-1]=1;
        }
        return new ArrayList<Integer>(Arrays.asList(res));
    }
}
