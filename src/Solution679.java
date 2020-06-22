import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution679 {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        boolean[] res = new boolean[]{false};
        for (int i : nums) {
            list.add((double) i);
        }
        dfs(list,res);
        return res[0];
    }

    private void dfs(List<Double> list,boolean[] res){
        if(res[0]){
            return;
        }
        if(list.size()==1){
            if(Math.abs(list.get(0)-24.0)<0.001){
                res[0] = true;
            }
            return;
        }
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                for(double c:getCandidates(list.get(i),list.get(j))){
                    List<Double> nextRound =  new ArrayList<>();
                    nextRound.add(c);
                    for(int k=0;k<list.size();k++){
                        if(k==i||k==j){
                            continue;
                        }
                        nextRound.add(list.get(k));
                    }
                    dfs(nextRound,res);
                }
            }
        }
    }

    private List<Double> getCandidates(double a, double b){
        List<Double> res = Arrays.asList(a+b,a-b,b-a,a*b,a/b,b/a);
        return res;
    }
}
