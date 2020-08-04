package solution201_400;

import java.util.*;

public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            return Collections.singletonList(0);
        }
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(adj.get(i).size()==1){
                leaves.add(i);
            }
        }
        while(n>2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int i:leaves){
                //a leave just has one adjacent vertex
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if(adj.get(j).size()==1){
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for(int i=0;i<n;i++){
            adj[i] = new LinkedList<>();
        }
        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] prev = new int[n];
        Arrays.fill(prev,-1);
        int p1 = bfs(adj,0,prev);
        Arrays.fill(prev,-1);
        int p2 = bfs(adj,p1,prev);
        List<Integer> path = new LinkedList<>();
        while(p2!=p1){
            path.add(p2);
            p2 = prev[p2];
        }
        path.add(p1);
        List<Integer> res = new ArrayList<>();
        int len = path.size();
        if(len%2==0){
            return Arrays.asList(path.get(len/2),path.get(len/2-1));
        }else{
            return Arrays.asList(path.get(len/2));
        }
    }
    private int bfs(List<Integer>[] adj, int start, int[] prev){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        prev[start] = start;
        int ans = start;
        while(!queue.isEmpty()){
            ans = queue.poll();
            for(int near:adj[ans]){
                //if prev[near] != -1, prove it near has been reached once
                //and as a tree, any node can be reached only once from root.
                //so if prev[near] is not -1, it means it wanna go back.
                if(prev[near]==-1){
                    queue.add(near);
                    prev[near] = ans;
                }
            }
        }
        return ans;
    }
}
