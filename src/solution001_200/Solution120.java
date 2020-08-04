package solution001_200;

import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        for (int i = 1; i < rows; i++) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0, len = cur.size(); j < len; j++) {
                cur.set(j,cur.get(j)+helper(triangle.get(i-1),j));
            }
        }
        int res = Integer.MAX_VALUE;
        for(Integer one : triangle.get(rows-1)){
            res= Math.min(res,one);
        }
        return res;
    }
    private int helper(List<Integer> list,int index){
        int len=list.size();
        int res = Integer.MAX_VALUE;
        if(index-1>=0) res=Math.min(res,list.get(index-1));
        if(index<len) res = Math.min(res,list.get(index));
        return res;
    }
}
