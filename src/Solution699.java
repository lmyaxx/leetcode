import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Solution699 {
    public List<Integer> fallingSquares(int[][] positions) {
        TreeMap<Integer,Integer> segment = new TreeMap<>();
        List<Integer> res = new ArrayList<>(positions.length);
        int max = 0;
        segment.put(0,0);
        for(int[] position:positions){
            int start = position[0], end = start + position[1];
            int last = segment.floorKey(start);
            int height = segment.subMap(last,end).values().stream().max(Integer::compare).get()+position[1];
            max = Math.max(max,height);
            res.add(max);
            int lastHeight = segment.floorEntry(end).getValue();
            segment.put(start,height);
            segment.put(end,lastHeight);
            segment.subMap(start, false, end, false).clear();
        }
        return res;
    }
}
