import java.util.ArrayList;

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph =  new ArrayList[numCourses];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        int degree[] = new int[numCourses];
        for(int [] prerequisite:prerequisites){
            graph[prerequisite[1]].add(prerequisite[0]);
            degree[prerequisite[0]]++;
        }

        int [] result = new int[numCourses];
        int left=0,right=0;
        for(int i=0;i<degree.length;i++){
            if(degree[i]==0){
                result[right++]=i;
            }
        }
        while(left<right){
            int course = result[left++];
            degree[course]--;
            for(Integer num:graph[course]){
                degree[num]--;
                if(degree[num]==0){
                    result[right++]=num;
                }
            }
        }
        if(left!=numCourses)
            return new int[0];
        else
            return result;
    }
}
