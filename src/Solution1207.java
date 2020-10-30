import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num,map.getOrDefault(num, 0) + 1);
        }
        HashSet<Integer> seen = new HashSet<>();
        for(Integer num : map.values()){
            if(!seen.add(num)){
                return false;
            }
        }
        return true;
    }
}
