package solution601_800;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Head> priorityQueue = new PriorityQueue<>(nums.size());
        int max=Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int row=0; row<nums.size(); row++){
            int val = nums.get(row).get(0);
            max = Math.max(val,max);
            min = Math.min(val,min);
            priorityQueue.add(new Head(row,0,val));
        }
        int begin = min, end = max;
        while(true){
            Head head = priorityQueue.poll();
            if(head.col+1>=nums.get(head.row).size()){
                break;
            }

            int val = nums.get(head.row).get(head.col+1);
            priorityQueue.add(new Head(head.row,head.col+1,val));
            begin = priorityQueue.peek().val;
            end = Math.max(end,val);
            if(end-begin<max-min){
                max = end;
                min = begin;
            }
        }
        return new int[]{min,max};
    }
    class Head implements Comparable<Head>{
        int row, col, val;
        public Head(int row,int col, int val){
           this.row = row;
           this.col = col;
           this.val = val;
        }
        @Override
        public int compareTo(Head o) {
            return Integer.compare(this.val,o.val);
        }
    }
}
