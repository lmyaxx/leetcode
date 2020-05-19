import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)-> a[1]-b[1] == 0 ? a[0]-b[0]:a[1]-b[1]);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for(int[] course:courses){
            if(course[0]>course[1]){
                continue;
            }
            if(sum + course[0]<=course[1]){
                priorityQueue.offer(course[0]);
                sum += course[0];
            }else{
                if(!priorityQueue.isEmpty()&&priorityQueue.peek()>course[0]){
                    sum += course[0] - priorityQueue.poll();
                    priorityQueue.offer(course[0]);
                }
            }
        }
        return priorityQueue.size();
    }
}
