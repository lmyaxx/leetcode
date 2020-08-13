package solution601_800;

public class Solution785 {
    public boolean isBipartite(int[][] graph) {
        int[] group = new int [graph.length];
        for(int i=0;i<graph.length;i++){
            if(group[i]==0){
                group[i] = 1;
                if(!dfs(graph,i,group)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int root,int[] group){
        int[] adj = graph[root];
        for(int i=0;i<adj.length;i++){
            if(group[adj[i]]==0){
                group[adj[i]] = group[root] % 2 + 1;
                if(!dfs(graph,adj[i],group)){
                    return false;
                }
            }else{
                if(group[adj[i]]==group[root]){
                    return false;
                }
            }
        }
        return true;
    }
}
