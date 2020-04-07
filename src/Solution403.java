import java.util.*;

/**
 * @Author : Chad li
 * @Date : 2020/4/6 18:13
 * @Version 1.0
 */
public class Solution403 {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int num:stones){
            map.put(num,new HashSet<>());
        }
        int max = stones[0];
        int dis = 0;
        int target = stones[stones.length-1];
        map.get(stones[0]).add(1);
        for(int pos:stones){
            if(pos>max){
                return false;
            }
            Iterator<Integer> iter = map.get(pos).iterator();
            while (iter.hasNext()){
                dis = iter.next();
                Set<Integer> set = map.get(dis+pos);
                if(set!=null){
                    set.add(dis+1);
                    set.add(dis);
                    if(dis != 1){
                        set.add(dis-1);
                    }
                }
                if(pos + dis==target){
                    return true;
                }
                max = Math.max(max, pos + dis);
            }
        }
        return false;
    }
}
