package Common;

import java.util.Collection;
import java.util.TreeMap;

/**
 * @Author : Chad li
 * @Date : 2020/4/1 17:00
 * @Version 1.0
 */
public class SummaryRanges {

    TreeMap<Integer,int[]> tree ;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if(tree.containsKey(val)) {
            return;
        }
        Integer left  = tree.lowerKey(val);
        Integer right  = tree.higherKey(val);
        int[] low = null;
        int[] high = null;
        if(left!=null){
            low = tree.get(left);
        }
        if(right!=null){
            high = tree.get(right);
        }
        if(low!=null&&right!=null&&val==low[1]+1&&val==high[0]-1){
            low[1] = high[1];
            tree.remove(right);
        }else if(low!=null&&low[1]+1>=val){
            low[1] = Math.max(low[1],val);
        }else if(high!=null&&high[0]-1<=val){
            high[0] = Math.min(val,high[0]);
        }else{
            tree.put(val,new int[]{val,val});
        }
    }

    public int[][] getIntervals() {
        Collection<int[]> values = tree.values();
        int[][] size = new int[values.size()][];
        int i=0;
        for(int[] value:values){
            size[i++] = value;
        }
        return size;
    }
}
