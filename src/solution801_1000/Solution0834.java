package solution801_1000;

import java.util.ArrayList;
import java.util.List;

public class Solution0834 {
    int[] ans;
    int[] sz;
    int[] dp;
    List<List<Integer>> graph;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        ans = new int[N];
        sz = new int[N];
        dp = new int[N];
        graph = new ArrayList<>();
        for(int i = 0; i< N; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        getChildrenCountAndDst(0,-1);
        traverseRoot(0,-1);
        return ans;
    }
    private void getChildrenCountAndDst(int cur, int from){
        sz[cur] = 1;
        for(int to: graph.get(cur)){
            if(to != from){
                getChildrenCountAndDst(to, cur);
                sz[cur] += sz[to];
                dp[cur] += sz[to] + dp[to];
            }
        }
    }

    private void traverseRoot(int cur, int from){
        ans[cur] = dp[cur];
        for(int to: graph.get(cur)){
            if(to != from){
                int cs = sz[cur],cd = dp[cur];
                int ts = sz[to], td = dp[to];
                dp[cur] -= dp[to] + sz[to];
                sz[cur] -= sz[to];
                sz[to] += sz[cur];
                dp[to] += dp[cur] + sz[cur];
                traverseRoot(to,cur);
                dp[cur] = cd;
                dp[to] = td;
                sz[cur] = cs;
                sz[to] = ts;
            }
        }
    }
}
