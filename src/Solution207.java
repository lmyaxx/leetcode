import java.util.*;

public class Solution207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        boolean visited[] = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
        if (visited[course]) {
            return false;
        } else {
            visited[course] = true;
        }
        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, (int) graph[course].get(i))) {
                return false;
            }
        }
        visited[course] = false;
        return true;
    }

    public boolean bfs(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int degree [] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
            degree[prerequisite[0]]++;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<degree.length;i++){
            if(degree[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int course = queue.poll();
            degree[course]--;
            count++;
            for(int i=0;i<graph[course].size();i++){
                int next = (int)graph[course].get(i);
                degree[next]--;
                if(degree[next]==0){
                    queue.offer(next);
                }
            }
        }
        return count==numCourses;
    }



}
