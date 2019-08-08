import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0) return res;
        res.add(Arrays.asList(new Integer[]{1}));
        if(numRows==1) return res;
        for(int i=2;i<=numRows;i++){
            List<Integer> one = new ArrayList<>();
            List<Integer> pre = res.get(i-2);
            one.add(1);
            for(int j=0,len=pre.size();j<len-1;j++)
                one.add(pre.get(j)+pre.get(j+1));
            res.add(one);
        }
        return res;
    }
}
