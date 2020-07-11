import java.util.*;

public class Solution1494 {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        int[] out = new int[n+1];
        int[] heights = new int[n+1];
        List<Integer>[] adj = new List[n+1];
        for(int i=1;i<=n;i++){
            adj[i] = new LinkedList<>();
        }
        for(int[] dp:dependencies){
            out[dp[0]] ++;
            adj[dp[1]].add(dp[0]);
        }
        for(int i = 1; i <= n; i++ ){
            if(out[i]==0){
                getHeight(heights,adj,i);
            }
        }

        int ans = 0;
        while(n>0){
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> heights[b] - heights[a]);
            for(int i = 1; i<out.length; i++){
                if(out[i]==0){
                    queue.add(i);
                }
            }
            int remove = Math.min(k,queue.size());
            n -= remove;
            for(int i=0;i<remove;i++){
                int root = queue.poll();
                out[root] = -1;
                for(int pre:adj[root]){
                    out[pre]--;
                }
            }
            ans ++;
        }
        return ans;
    }

    private void getHeight(int[] height, List<Integer>[] adj,int root){
        for(int pre:adj[root]){
            getHeight(height,adj,pre);
            height[root] = Math.max(height[root],height[pre] + 1);
        }
    }

}
