package solution1401_1600;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Solution1499 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        // [yj + xj]+ yi - xi
        int res = Integer.MIN_VALUE, len = points.length;
        //key: val ; value : count
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(points[len-1][0] + points[len-1][1],1);
        Queue<Integer> queue = new LinkedList();
        queue.offer(len-1);
        for(int i = points.length-2; i>=0; i--){
            while(!queue.isEmpty()&&points[queue.peek()][0]-points[i][0]>k){
                int cur =  queue.poll();
                int sum = points[cur][0] + points[cur][1];
                int count = treeMap.get(sum);
                if(count==1){
                    treeMap.remove(sum);
                }else{
                    treeMap.put(sum,count-1);
                }
            }
            if(!queue.isEmpty()){
                // max = [yj + xj]
                int max = treeMap.lastKey();
                //points[i][1] - points[i][0] = yi - xi
                res = Math.max(res, max + points[i][1] - points[i][0] );
            }
            queue.offer(i);
            int sum = points[i][0] + points[i][1];
            treeMap.put(sum,treeMap.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
