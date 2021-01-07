package solution401_600;

/**
 * @author: chad li
 * @date: 2021/1/7
 * @discription:
 */
public class Solution0547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int ans = 0;
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                dfs(isConnected,i,visited, n);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int[][] isConnected, int start, boolean[] visited, int n){
        visited[start] = true;
        for(int i = 0; i < n; i++){
            if(start!=i && isConnected[start][i]==1&&!visited[i]){
                dfs(isConnected,i,visited,n);
            }
        }
    }
}
