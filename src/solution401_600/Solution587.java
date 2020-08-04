package solution401_600;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution587 {
    public int[][] outerTrees(int[][] points) {
        if(points.length<=3){
            return points;
        }
        int start = 0;
        for(int i = 1;i<points.length;i++){
            if(points[i][0]<points[start][0]){
                start = i;
            } else if(points[i][0]==points[start][0]&&points[i][1]<points[start][1]){
                start = i;
            }
        }
        int begin = start;
        Set<Integer> res = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        res.add(start);
        while (true){
            int cur = 0;
            for(int i=1;i<points.length;i++){
                if(i==start){
                    continue;
                }
                int cmp = isOnLeft(points,start,cur,i);
                if(cmp>0){
                    cur = i;
                    list = new LinkedList<>();
                }else if(cmp==0){
                    if(distance(points,start,cur,i)<0){
                        list.add(cur);
                        cur = i;
                    }else {
                        list.add(i);
                    }
                }
            }
            for(Integer i:list){
                res.add(i);
            }
            if(begin == cur){
                break;
            }
            res.add(cur);
            start = cur;
        }
        int[][] ans = new int[res.size()][];
        int i=0;
        for(Integer pos:res){
            ans[i++] = points[pos];
        }
        return ans;
    }

    private int isOnLeft(int[][]points, int start, int cur, int next){
        int x1 =  points[cur][0] - points[start][0], x2 = points[next][0] - points[start][0];
        int y1 = points[cur][1] - points[start][1], y2 = points[next][1] - points[start][1];
        return (x1*y2-x2*y1);
    }

    private int distance(int[][]points, int start, int cur, int next){
        int x1 =  points[cur][0] - points[start][0], x2 = points[next][0] - points[start][0];
        int y1 = points[cur][1] - points[start][1], y2 = points[next][1] - points[start][1];
        return Integer.compare(x1*x1 + y1*y1,x2*x2+y2*y2);
    }

}
