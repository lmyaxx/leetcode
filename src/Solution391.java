import java.util.HashSet;
import java.util.Set;

/**
 * @Author : Chad li
 * @Date : 2020/4/6 17:40
 * @Version 1.0
 */
public class Solution391 {
    public boolean isRectangleCover(int[][] rectangles) {
        if(rectangles==null||rectangles.length==0){
            return false;
        }
        long left = Long.MAX_VALUE, down = Long.MAX_VALUE, up = Long.MIN_VALUE , right = Long.MIN_VALUE;
        long area = 0;
        Set<String> set = new HashSet<>();
        for(int[] rec:rectangles){
            left = Math.min(rec[0],left);
            down = Math.min(rec[1],down);
            right = Math.max(rec[2],right);
            up = Math.max(rec[3],up);
            area += (rec[3] - rec[1])*(rec[2] - rec[0]);
            String p1 = rec[0] + " " + rec[1];
            String p2 = rec[0] + " " + rec[3];
            String p3 = rec[2] + " " + rec[3];
            String p4 = rec[2] + " " + rec[1];
            if(!set.add(p1)){
                set.remove(p1);
            }
            if(!set.add(p2)){
                set.remove(p2);
            }
            if(!set.add(p3)){
                set.remove(p3);
            }
            if(!set.add(p4)){
                set.remove(p4);
            }
        }
        return set.contains(left+" "+down) && set.contains(left+" "+up) && set.contains(right+" "+down) &&
                set.contains(right+" "+up) && set.size() == 4 && area == ((long)up - down) * (right-left);
    }
}
