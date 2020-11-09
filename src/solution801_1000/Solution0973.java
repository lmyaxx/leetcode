package solution801_1000;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution0973 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (b[0] * b[0] + b[1] * b[1]) - (a[0]* a[0] + a[1] * a[1]));
        for(int[] point: points){
            pq.offer(point);
            if(pq.size()>K){
                pq.poll();
            }
        }
        return pq.toArray(new int[pq.size()][]);
    }
}
