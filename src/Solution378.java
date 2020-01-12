import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author : Chad li
 * @Date : 2020/1/12 9:21
 * @Version 1.0
 */
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Tuple> queue = new PriorityQueue<>();
        int height = matrix.length;
        for(int row=0; row<height;row++){
            queue.offer(new Tuple(row,0,matrix[row][0]));
        }
        while(k-->1){
            Tuple t = queue.poll();
            if(t.y >= height-1){
                continue;
            }
            queue.offer(new Tuple(t.x,t.y+1,matrix[t.x][t.y+1]));
        }
        return queue.poll().val;
    }
}

class Tuple implements Comparable<Tuple>{
    int x,y,val;
    public Tuple(int x,int y,int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Tuple o) {
        return this.val - o.val;
    }
}
