import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Solution149 {

    public int maxPoints(int[][] points) {
        int res=0;
        for(int i=0;i<points.length;i++){
            int duplicate = 0;
            Map<Pair<Integer,Integer>,Integer> map = new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i==j)
                    continue;
                int dx = points[i][0]-points[j][0];
                int dy = points[i][1]-points[j][1];
                if(dx==0&&dy==0){
                    duplicate++;
                    continue;
                }
                int prime = gcd(dx,dy);
                Pair<Integer,Integer> key = new Pair<>(dx/prime,dy/prime);
                map.put(key,map.getOrDefault(key,1)+1);
            }
            res = Math.max(duplicate+1,res);
            for(int num:map.values())
                res=Math.max(num+duplicate,res);
            System.out.println(i);
            System.out.println(res);
        }
        return res;
    }

    private int gcd(int dx, int dy) {
        return (dy == 0) ? dx : gcd(dy, dx % dy);
    }
}
