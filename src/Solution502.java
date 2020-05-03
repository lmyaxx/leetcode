import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author : Chad li
 * @Date : 2020/5/3 17:58
 * @Version 1.0
 */
public class Solution502 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Project[] projects = new Project[Profits.length];
        for(int i=0;i<Profits.length;i++){
            projects[i] = new Project(Profits[i],Capital[i]);
        }
        Arrays.sort(projects);
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,(a,b)->b-a);
        int idx = 0;
        while(idx<projects.length&&projects[idx].capital<=W){
            queue.add(projects[idx++].profits);
        }
        int res = W;
        while(queue.size()>0&&k>0){
            res += queue.poll();
            while(idx<projects.length&&projects[idx].capital<=res){
                queue.add(projects[idx++].profits);
            }
            k--;
        }
        return res;
    }

    class Project implements Comparable<Project>{
        int profits;
        int capital;
        public Project(int profits,int capital){
            this.capital = capital;
            this.profits = profits;
        }

        @Override
        public int compareTo(Project o) {
            return Integer.compare(this.capital,o.capital);
        }
    }
}
